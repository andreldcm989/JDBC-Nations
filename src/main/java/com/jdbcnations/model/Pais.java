package com.jdbcnations.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pais {

    private String codigo;
    private String nomePais;
    private String capital;
    private String continente;
    private Set<Cidade> cidades = new HashSet<>();

    public Pais() {
    }

    public Pais(String codigo, String nomePais, String capital, String continente) {
        this.codigo = codigo;
        this.nomePais = nomePais;
        this.capital = capital;
        this.continente = continente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Set<Cidade> getCidades() {
        return Collections.unmodifiableSet(cidades);
    }

    public void adicionar(Cidade cidade) {
        cidades.add(cidade);
    }

    @Override
    public String toString() {
        return String.format("Cód.: %-4s | País: %-20s | Capital: %-30s | Continente: %-20s", codigo, nomePais, capital,
                continente);
    }

}
