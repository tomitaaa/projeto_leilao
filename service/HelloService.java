package com.github.tomitaaa.backend.service;

import org.springframework.stereotype.Service;

import com.github.tomitaaa.backend.model.Calculadora;

@Service
public class HelloService {

    public Calculadora somar(Calculadora calculadora){
        calculadora.setResultado(calculadora.getValor1()+ calculadora.getValor2()) ;
        return calculadora;
    }

}
