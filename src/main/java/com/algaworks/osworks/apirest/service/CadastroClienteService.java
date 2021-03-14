package com.algaworks.osworks.apirest.service;

import com.algaworks.osworks.apirest.model.Cliente;
import com.algaworks.osworks.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Na pasta Service devem estar todas as regras de negócio
//@Service permite que a classe se torne um componente

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Método pra salvar o cliente
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Método pra deletar o cliente
    public void excluir (Long clienteId){
      clienteRepository.deleteById(clienteId);
    }

}
