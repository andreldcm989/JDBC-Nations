package com.jdbcnations;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TesteConexaoMySQL {
    private String url = "jdbc:mysql://localhost:3306/world";
    private String user = "root";
    private String senha = "12345678";
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Test
    public void testaConexaoJDBC() {
        try (Connection conn = DriverManager.getConnection(url, user, senha)) {
            System.out.println("Conexão iniciada!");
        } catch (Exception e) {
            System.out.println("Conexão falhou!");
            assertEquals("Access denied for user 'root'@'localhost' (using password: YES)", e.getMessage());
        }
    }

    @Test
    public void verificaContinenteDoBrasil() {
        try (Connection conn = DriverManager.getConnection(url, user, senha)) {
            ps = conn.prepareStatement("SELECT region FROM country WHERE code = ?");
            ps.setString(1, "BRA");
            rs = ps.executeQuery();
            while (rs.next()) {
                String continente = rs.getString("Region");
                assertEquals("South America", continente);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Conexão falhou!");
            System.out.println(e.getMessage());
        }
    }
}
