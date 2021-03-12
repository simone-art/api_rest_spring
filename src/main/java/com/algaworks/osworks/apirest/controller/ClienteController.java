package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.model.Cliente;
import com.algaworks.osworks.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //"From Cliente" é uma linguagem JPQL, parecida a SQL,
    // onde você está dizendo que faça uma busca por todos os clientes
    // E oa usar getResultList() você tipa a consulta, estabelecendo que
    //Você quer uma lista de clientes

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
     return entityManager.createQuery("From Cliente", Cliente.class).getResultList();
    }
}
