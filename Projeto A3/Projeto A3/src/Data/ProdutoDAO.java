package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Produto;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // CREATE
    public void inserirProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (id, nome, categoria, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produto.id);
            stmt.setString(2, produto.nome);
            stmt.setString(3, produto.categoria);
            stmt.setDouble(4, produto.preco);
            stmt.setInt(5, produto.quantidade);
            stmt.executeUpdate();
        }
    }

    // READ (consulta por ID)
    public Produto buscarProdutoPorId(String id) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
                );
            }
        }
        return null;
    }

    // UPDATE
    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, categoria = ?, preco = ?, quantidade = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.nome);
            stmt.setString(2, produto.categoria);
            stmt.setDouble(3, produto.preco);
            stmt.setInt(4, produto.quantidade);
            stmt.setInt(5, produto.id);
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarProduto(String id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    // LISTAR TODOS
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
                );
                lista.add(p);
            }
        }
        return lista;
    }
}