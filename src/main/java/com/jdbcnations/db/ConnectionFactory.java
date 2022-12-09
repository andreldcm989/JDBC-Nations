package com.jdbcnations.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private String url = "jdbc:mysql://localhost:3306/world";
    private String user = "root";
    private String senha = "12345678";
    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setJdbcUrl(url);
        pool.setUser(user);
        pool.setPassword(senha);
        pool.setMaxPoolSize(10);
        this.dataSource = pool;
    }

    public Connection abrirConexao() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Conexão falhou!");
        }
    }

}
