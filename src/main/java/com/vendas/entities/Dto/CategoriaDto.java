package com.vendas.entities.Dto;

public class CategoriaDto {

    protected long id;

    protected String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
