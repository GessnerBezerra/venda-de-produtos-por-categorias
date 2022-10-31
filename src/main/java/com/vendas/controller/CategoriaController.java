package com.vendas.controller;

import com.vendas.entities.Categoria;
import com.vendas.entities.Dto.CategoriaDto;
import com.vendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> read(){
        List<CategoriaDto> categoria = service.findAll();
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> find(@RequestParam("id") Long id){
        CategoriaDto categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> insert(@RequestBody CategoriaDto ctgr){
        CategoriaDto growresult = service.save(ctgr);

        return ResponseEntity.ok().body(growresult);
    }

    @PutMapping("/{id}")
    public String atuaçizar(@PathVariable("id") Long id, @RequestBody CategoriaDto ctgrDto){
        service.atualizar(id, ctgrDto);
        return "Atualizado com sucesso";
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String>  remove(@PathVariable("id") Long id){
        String deletado =  service.delete(id);
//        ResponseEntity.ok().build();
        return ResponseEntity.ok().body(deletado);
    }
}
