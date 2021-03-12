package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.model.Cliente;
import com.algaworks.osworks.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
     return clienteRepository.findAll();
      //return clienteRepository.findByNomeContaining("mo");
    }

    //OPTIONAL é um container que pode estar nulo ou conter algum dado
    //O optional extrai o que está dentro do cliente e se não tiver nada retorna nulo
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
       Optional<Cliente>  cliente = clienteRepository.findById(clienteId);

       if(cliente.isPresent()){
           return ResponseEntity.ok(cliente.get());
       }
        return ResponseEntity.notFound().build();
    }
}
