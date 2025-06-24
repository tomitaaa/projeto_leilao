package com.github.tomitaaa.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.tomitaaa.backend.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import com.github.tomitaaa.backend.model.Pessoa;

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
        pessoaService.excluir(id);
        return ResponseEntity.ok("Excluído");
    }
    
}