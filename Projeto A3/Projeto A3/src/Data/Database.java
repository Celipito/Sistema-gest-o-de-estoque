package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
   static final String JDBC_DRIVE = "com.mysql.cj.jdbc.Driver";
   static final String URL = "jdbc:mysql://localhost:3306/gestãodeprodutos";
   static final String USER = "root";
   static final String PASS = "Estoque123";
   static Connection dbconn = null;
   static Statement sqlmgr = null;
   static ResultSet rs = null;
   public static String mensagem;

   public Database() {
   }

   public static Connection getconnection() throws SQLException {
      if (dbconn == null || dbconn.isClosed()) {
         connection();
      }

      return dbconn;
   }

   public static void connection() throws SQLException {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         dbconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestãodeprodutos", "root", "Estoque123");
         System.out.println("Conectado ao banco de dados com sucesso em: jdbc:mysql://localhost:3306/gestãodeprodutos");
         sqlmgr = dbconn.createStatement();
      } catch (ClassNotFoundException | SQLException var1) {
         mensagem = "Erro ao conectar ao banco de dados: " + var1.getMessage();
         System.out.println(mensagem);
         CloseDatabase();
      }

   }

   public static void CloseDatabase() throws SQLException {
      try {
         if (rs != null) {
            rs.close();
         }

         if (sqlmgr != null) {
            sqlmgr.close();
         }

         if (dbconn != null) {
            dbconn.close();
         }

         System.out.println("Conexão com o banco de dados fechada com sucesso!");
      } catch (SQLException var1) {
         mensagem = "Erro ao fechar a conexão com o banco de dados: " + var1.getMessage();
         System.out.println(mensagem);
      }

   }

   public String InsertData(String sql) {
      try {
         sqlmgr.executeUpdate(sql);
      } catch (SQLException var3) {
         mensagem = "Erro ao inserir dados no banco de dados: " + var3.getMessage();
         System.out.println(mensagem);
         return mensagem;
      }

      System.out.println("Dados inseridos com sucesso! - " + sql);
      return "Dados inseridos com sucesso!";
   }

   public String UpdateData(String sql) {
      try {
         sqlmgr.executeUpdate(sql);
         return "Dados atualizados com sucesso!";
      } catch (SQLException var3) {
         mensagem = "Erro ao atualizar dados no banco de dados: " + var3.getMessage();
         System.out.println(mensagem);
         return mensagem;
      }
   }

   public String DeleteData(String sql) {
      try {
         sqlmgr.executeUpdate(sql);
         return "Dados deletados com sucesso!";
      } catch (SQLException var3) {
         mensagem = "Erro ao deletar dados no banco de dados: " + var3.getMessage();
         System.out.println(mensagem);
         return mensagem;
      }
   }

   public static ResultSet SelectData(String sql) {
      try {
         rs = sqlmgr.executeQuery(sql);
      } catch (SQLException var2) {
         mensagem = "Erro ao executar consulta no banco de dados: " + var2.getMessage();
         System.out.println(mensagem);
      }

      return rs;
   }
}

    

