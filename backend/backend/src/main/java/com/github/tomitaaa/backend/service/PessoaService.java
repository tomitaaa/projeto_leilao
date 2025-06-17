package com.github.tomitaaa.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.tomitaaa.backend.model.Pessoa;
import com.github.tomitaaa.backend.repository.PessoaRepository;

@Service
public class PessoaService{
    @Autowired
    private PMessageSource messageSource;

    public Pessoa inserir(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public Pessoa alterar(Pessoa pessoa) {
       //return pessoaRepository.save(pessoa);
       Pessoa pessoaBanco = pessoaRepository.findById(pessoa.getId().orElseThrow(() -> new NoSuchElementException(messageSource.getMessage
       ("pessoa.notfound", new Object[]{pessoa.getId()},LocaleContextHolder.getLocale()))));
        pessoaBanco.setNome(pessoa.getNome());
        pessoaBanco.setEmail(pessoa.getEmail());
        return pessoaRepository.save(pessoaBanco);
        
    }

    public void excluir(Long id) {
        Pessoa pessoaBanco = buscarPorId(id);
        pessoaRepository.delete(pessoa);
    }

    public Pessoa buscarPorId(Long id){
        return pessoaRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException(messageSource.getMessage
            ("pessoa.notfound", new Object[]{id}, LocaleContextHolder.getLocale())));

    }

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }
}