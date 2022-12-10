package com.jdbcnations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jdbcnations.db.ConnectionFactory;
import com.jdbcnations.model.Cidade;
import com.jdbcnations.model.Pais;
import com.jdbcnations.model.dto.CidadeDAO;
import com.jdbcnations.model.dto.PaisDAO;

public class App {
    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection conn = factory.abrirConexao()) {
            PaisDAO dao = new PaisDAO(conn);
            List<Pais> paises = dao.listarPaisesPorContinente("South America");
            paises.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Deu erro!");
        }

        System.out.println("------------------------------------------------------------------------------------");

        try (Connection conn = factory.abrirConexao()) {
            CidadeDAO dao = new CidadeDAO(conn);
            List<Cidade> cidades = dao.buscarCidadePorPaisEEstado("BRA", "minas");
            cidades.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Deu erro!");
        }
    }
}
