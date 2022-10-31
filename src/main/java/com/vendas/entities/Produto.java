package com.vendas.entities;

import java.util.Objects;

public class Produto {

    private Long id;

    private String nome;

    private String descricao;

    private Categoria categoria;


    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return id.equals(produto.id) && nome.equals(produto.nome) && descricao.equals(produto.descricao) && categoria.equals(produto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, categoria);
    }

    @Override
    public String toString() {
        return "\nProduto: " +'\n'+
                " id:        "+id +'\n'+
                " nome:      "+nome + '\n' +
                " descricao: "+descricao + '\n'+
                " categoria: "+categoria+ '\n';
    }


}
