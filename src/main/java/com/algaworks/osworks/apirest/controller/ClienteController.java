package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        var cliente2 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Simone");
        cliente1.setEmail("simonesantos@gmail.com");
        cliente1.setTelefone("11 9999 8888");

        cliente2.setId(2L);
        cliente2.setNome("Polo");
        cliente2.setEmail("beltrandpolo56@gmail.com");
        cliente2.setTelefone("11 9999 7777");
        return Arrays.asList(cliente1, cliente2);
    }
}
