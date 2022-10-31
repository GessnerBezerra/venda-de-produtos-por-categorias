package com.vendas.services;

import com.vendas.entities.Categoria;
import com.vendas.entities.Dto.CategoriaDto;
import com.vendas.entities.Dto.ProdDto;
import com.vendas.entities.Produto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


@Service
public class ProdutoService {


    @Autowired
    private CategoriaService service;

    Random aux= new Random();
    List<Produto> prodList = new ArrayList<>();

    public ProdDto save(ProdDto produto) {

        Produto prodt = new Produto();

        if (Objects.nonNull(produto)) {
            long num = aux.nextInt(500);
            prodt.setId(num);
            prodt.setNome(produto.getNome());
            prodt.setDescricao(produto.getDescricao());

            CategoriaDto ct = service.findById(produto.getCategoriaId());

            Categoria ct2 = new Categoria(ct.getNome(), ct.getId());

            prodt.setCategoria(ct2);
            prodList.add(prodt);
        } else {
            prodList = new ArrayList<>();
        }
        return produto;
    }

    //funcao para listar todos growdevers
    public List<Produto> findAll() {
        return prodList;
    }

    public Produto findById(Long id){
        Produto prod = new Produto();
        ProdDto prdDto = new ProdDto();
        for( Produto prd : prodList){
            if (prd.getId().equals(id)){
                prod.setId(prd.getId());
                prod.setNome(prd.getNome());
                prod.setDescricao(prd.getDescricao());
//                prod.setCategoria(prod.getCategoria());
                CategoriaDto ct = service.findById(prd.getCategoria().getId());

                Categoria ct2 = new Categoria(ct.getNome(), ct.getId());

                prod.setCategoria(ct2);

            }
        }
        return  prod;
    }

    public Produto atualizar(Long id, @NotNull Produto obj){
//        CategoriaDto cat = service.findById(obj.getCategoria().getId());
//        Categoria ct2 = new Categoria(cat.getNome(), cat.getId());
        Produto prod = new Produto();
//        ProdDto prod2 = new ProdDto();
        for (Produto prd : prodList) {
            if (prd.getId().equals(id)) {
                prd.setId(obj.getId());
                prd.setNome(obj.getNome());
                prd.setDescricao(obj.getDescricao());
//                prd.setCategoria(ct2);
                prod = prd;
            }
        }
        return prod;
    }


    public String delete(Long id) {
        Produto prod = new Produto();
        for (Produto prd : prodList) {
            if (prd.getId().equals(id)) {
                prod = prd;
                prodList.remove(prd);
            }
        }
        return "Produto com Id "+id+" removido com sucesso";
    }


}
