package com.jdbcnations;

import com.jdbcnations.db.ConnectionFactory;

public class App {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        for (int i = 1; i <= 20; i++) {
            factory.abrirConexao();
            System.out.println("Conexão nº " + i);
        }
    }
}
