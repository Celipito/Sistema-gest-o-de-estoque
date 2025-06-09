package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Funcionarios;

public class FuncionariosDAO {
    private Connection conexao;

    public FuncionariosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirFuncionario(Funcionarios f) throws SQLException {
        String sql = "INSERT INTO funcionarios (id, nome, cargo, login, senha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCargo());
            stmt.setString(4, f.getLogin());
            stmt.setString(5, f.getSenha());
            stmt.executeUpdate();
        }
    }

    public List<Funcionarios> listarFuncionarios() throws SQLException {
        List<Funcionarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionarios f = new Funcionarios(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha")
                );
                lista.add(f);
            }
        }
        return lista;
    }

    public Funcionarios autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionarios(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha")
                );
            }
        }
        return null;
    }
}


    
