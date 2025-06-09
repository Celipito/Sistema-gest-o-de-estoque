package Data;
import Model.Entrada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {
    private Connection conexao;

    public EntradaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirEntrada(Entrada entrada) throws SQLException {
        String sql = "INSERT INTO entrada (id, id_produto, data_entrada, quantidade, fornecedor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, entrada.getId());
            stmt.setInt(2, entrada.getIdProduto());
            stmt.setString(3, entrada.getDataEntrada());
            stmt.setInt(4, entrada.getQuantidade());
            stmt.setDouble(5, entrada.getFornecedor());
            stmt.executeUpdate();
        }
    }

    public List<Entrada> listarEntradas() throws SQLException {
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM entrada";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Entrada entrada = new Entrada(
                    rs.getInt("id"),
                    rs.getInt("id_produto"),
                    rs.getString("data_entrada"),
                    rs.getInt("quantidade"),
                    rs.getDouble("fornecedor")
                );
                entradas.add(entrada);
            }
        }
        return entradas;
    }
}


