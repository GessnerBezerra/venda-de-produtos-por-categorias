package com.vendas.services;

import com.vendas.entities.Categoria;
import com.vendas.entities.Dto.CategoriaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class CategoriaService {

    Random aux= new Random();
    List<Categoria> categoriaList = new ArrayList<>();

    public CategoriaDto save(CategoriaDto categoria) {
        Categoria categ = new Categoria();
        CategoriaDto ctg = new CategoriaDto();
        if (Objects.nonNull(categoria)) {
            long num = aux.nextInt(500);
            categ.setId(num);
            categ.setNome(categoria.getNome());
            categoriaList.add(categ);
        } else {
            categoriaList = new ArrayList<>();
        }
        return categoria;
    }

    //funcao para listar todos growdevers
    public List<CategoriaDto> findAll() {
        List<CategoriaDto> categ = new ArrayList<>();
        for (Categoria ctg : categoriaList) {
            CategoriaDto ctDto = new CategoriaDto(ctg.getId(), ctg.getNome());
            categ.add(ctDto);
        }
        return categ;
    }

    public CategoriaDto findById(Long id) {
        CategoriaDto categ = new CategoriaDto();
        for (Categoria ctg : categoriaList) {
            if (ctg.getId().equals(id)) {
                categ.setId(ctg.getId());
                categ.setNome(ctg.getNome());
            }
        }
        return categ;
    }

    public void atualizar(Long id, CategoriaDto obj){
//        Categoria categ = new Categoria();
        for (Categoria ctg : categoriaList) {
            if (ctg.getId().equals(id)) {
//                categ = ctg;
                ctg.setNome(obj.getNome());
            }
        }
    }

    public String delete(Long id) {
        for (Categoria ctg : categoriaList) {
            if (ctg.getId()== id) {
                categoriaList.remove(ctg);
            }
        }
        return "Categora com Id "+id+" removido com sucesso";
    }
}
