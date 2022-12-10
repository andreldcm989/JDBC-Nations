package com.jdbcnations.model;

public class Cidade {

    private int id;
    private String nomeCidade;
    private String estado;
    private Pais pais;

    public Cidade() {
    }

    public Cidade(int id, String nomeCidade, String estado, Pais pais) {
        this.id = id;
        this.nomeCidade = nomeCidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", nomeCidade, estado);
    }

}
