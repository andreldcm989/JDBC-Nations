package com.jdbcnations.model.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcnations.model.Cidade;
import com.jdbcnations.model.Pais;

public class CidadeDAO {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public CidadeDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Cidade> buscarCidadePorPaisEEstado(String codPais, String estado) {
        List<Cidade> cidades = new ArrayList<>();
        String query = """
                SELECT
                    c.id,
                    c.name as cidade,
                    c.district as estado,
                    p.code,
                    p.name as pais,
                    c.name as capital,
                    p.continent as continente
                FROM city c
                INNER JOIN country p on p.code = c.CountryCode
                WHERE c.CountryCode LIKE ? AND c.District LIKE ?;
                """;
        try {
            st = conn.prepareStatement(query);
            st.setString(1, "%" + codPais + "%");
            st.setString(2, "%" + estado + "%");
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nomeCidade = rs.getString(2);
                String distrito = rs.getString(3);
                String codigo = rs.getString(4);
                String nomePais = rs.getString(5);
                String capital = rs.getString(6);
                String continente = rs.getString(7);
                Pais pais = new Pais(codigo, nomePais, capital, continente);
                cidades.add(new Cidade(id, nomeCidade, distrito, pais));
            }
            encerrarConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidades;
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
