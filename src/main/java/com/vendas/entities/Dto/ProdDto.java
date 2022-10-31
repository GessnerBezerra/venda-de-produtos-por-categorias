package com.vendas.entities.Dto;

import java.util.Random;

public class ProdDto {
    private  long id;

    private String nome;

    private String descricao;

    private long categoriaId;

    Random aux= new Random();

    int num = aux.nextInt(500);

    public ProdDto() {
        this.id = num;
    }

    public ProdDto(long id, String nome, String descricao, long categoriaId) {
        this.id = num;
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
