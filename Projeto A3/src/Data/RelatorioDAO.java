package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Relatorio;

public class RelatorioDAO {
    private Connection conexao;

    public RelatorioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirRelatorio(Relatorio r) throws SQLException {
        String sql = "INSERT INTO relatorios (id, tipo, data, detalhes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, r.getId());
            stmt.setString(2, r.getTipo());
            stmt.setDate(3, new java.sql.Date(r.getData().getTime()));
            stmt.setString(4, r.getDetalhes());
            stmt.executeUpdate();
        }
    }

    public List<Relatorio> listarRelatorios() throws SQLException {
        List<Relatorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM relatorios";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Relatorio r = new Relatorio(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getDate("data"),
                    rs.getString("detalhes")
                );
                lista.add(r);
            }
        }
        return lista;
    }
}

