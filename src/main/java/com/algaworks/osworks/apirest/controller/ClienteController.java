package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.model.Cliente;
import com.algaworks.osworks.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
//@RequestMapping("/clientes") ele controla tudo o que vem depois do /clientes
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
     return clienteRepository.findAll();
      //return clienteRepository.findByNomeContaining("mo");
    }

    //OPTIONAL é um container que pode estar nulo ou conter algum dado
    //O optional extrai o que está dentro do cliente e se não tiver nada retorna nulo
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
       Optional<Cliente>  cliente = clienteRepository.findById(clienteId);

       if(cliente.isPresent()){
           return ResponseEntity.ok(cliente.get());
       }
        return ResponseEntity.notFound().build();
    }

    //Método pra adicionar cliente

    @PostMapping
    public Cliente adicionarNovoCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);

    }
}
