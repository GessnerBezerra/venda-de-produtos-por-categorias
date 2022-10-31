package com.vendas.controller;

import com.vendas.entities.Dto.ProdDto;
import com.vendas.entities.Produto;
import com.vendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> read(){
        List<Produto> produto = service.findAll();
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> find(@PathVariable Long id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }


    @PostMapping
    public ResponseEntity<ProdDto> insert(@RequestBody ProdDto prd){
        ProdDto prodresult = service.save(prd);

        return ResponseEntity.ok().body(prodresult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable("id") Long id, @RequestBody Produto prd){
        Produto produtosAtualizada = service.atualizar(id, prd);
        return ResponseEntity.ok().body(produtosAtualizada);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String>  remove(@PathVariable Long id){
        String deletado =  service.delete(id);
//        ResponseEntity.ok().build();
        return ResponseEntity.ok().body(deletado);
    }

}
