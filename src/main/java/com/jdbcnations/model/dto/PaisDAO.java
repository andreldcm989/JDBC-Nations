package com.jdbcnations.model.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcnations.model.Pais;

public class PaisDAO {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public PaisDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Pais> listarPaisesPorContinente(String continente) throws SQLException {
        List<Pais> paises = new ArrayList<>();
        String query = """
                SELECT
                    p.code, p.name, c.name, p.continent
                    FROM country p
                    INNER JOIN city c ON c.id = p.capital
                    WHERE p.continent = ?;
                """;
        try {
            st = conn.prepareStatement(query);
            st.setString(1, continente);
            rs = st.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nomePais = rs.getString(2);
                String capital = rs.getString(3);
                String continent = rs.getString(4);
                paises.add(new Pais(codigo, nomePais, capital, continent));
            }
            encerrarConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }

    public void encerrarConexao() {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encerrar conexão. " + e.getMessage());
        }
    }
}
