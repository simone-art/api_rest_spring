package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    //Variável de instância que permite
    //EntityManager é uma interfase do Jakarta Persistence que é usada pra fzer operações nas entidades
    //Como consulta, criação, exclusão, etc.
    //Pra o EntityManager estar disponível, ele deve ser instânciado e injetado no controller por medio
    //Da anotação @PersistenceContext

    @PersistenceContext
    private EntityManager entityManager;

//    @GetMapping("/clientes")
//    public List<Cliente> listar(){
//
//    }
}
