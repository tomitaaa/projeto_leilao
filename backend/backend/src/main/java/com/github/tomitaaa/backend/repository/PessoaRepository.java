package com.github.tomitaaa.backend.repository;
import com.github.tomitaaa.backend.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    
}