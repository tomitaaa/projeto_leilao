package com.leilao.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.leilao.backend.service.PessoaService;
import java.util.List;


@RestController
@RequestMapping("/pessoa")
public class PessoaController{

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodos(){
        return ResponseEntity.ok(pessoaService.buscarTodos());

    }

    @PostMapping
    public ResponseEntity<Pessoa> inserir(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.ok(pessoaService.inserir(pessoa));
    }
    
    @PutMapping
    public ResponseEntity<Pessoa> alterar(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.ok(pessoaService.alterar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathParam("id") Long id){
        pessoaService.exlcuir(id);
        return ResponseEntity.ok("Excluído");
    }
    
}