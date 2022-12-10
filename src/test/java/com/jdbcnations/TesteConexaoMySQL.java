package com.jdbcnations;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.*;

import com.jdbcnations.db.ConnectionFactory;

public class TesteConexaoMySQL {
    private static ConnectionFactory factory;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @BeforeAll
    public static void instanciaFabricaDeConexao() {
        factory = new ConnectionFactory();
    }

    @Test
    public void testaConexaoJDBC() {
        try (Connection conn = factory.abrirConexao()) {
            System.out.println("Conexão iniciada!");
        } catch (SQLException e) {
            System.out.println("Conexão falhou!");
            assertEquals("Access denied for user 'root'@'localhost' (using password: YES)", e.getMessage());
        }
    }

    @Test
    public void verificaContinenteDoBrasil() throws SQLException {
        Connection conn = factory.abrirConexao();
        ps = conn.prepareStatement("SELECT region FROM country WHERE code = ?");
        ps.setString(1, "BRA");
        rs = ps.executeQuery();
        while (rs.next()) {
            String continente = rs.getString("Region");
            assertEquals("South America", continente);
        }
        rs.close();
        ps.close();
        conn.close();
    }

    @Test
    public void testaConexoesComDataSource() {
        ConnectionFactory factory = new ConnectionFactory();
        for (int i = 1; i <= 10; i++) {
            factory.abrirConexao();
            System.out.println("Conexão nº " + i);
        }
    }
}
