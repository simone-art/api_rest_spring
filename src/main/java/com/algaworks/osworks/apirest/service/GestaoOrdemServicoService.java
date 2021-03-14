package com.algaworks.osworks.apirest.service;

import com.algaworks.osworks.apirest.exception.NegocioException;
import com.algaworks.osworks.apirest.model.Cliente;
import com.algaworks.osworks.apirest.model.OrdemServico;
import com.algaworks.osworks.apirest.model.StatusOrdemDeServico;
import com.algaworks.osworks.apirest.repository.ClienteRepository;
import com.algaworks.osworks.apirest.repository.OrdemServicoRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    //Precisa_Se desta injeccão de dependência pra buscar o cliente pelo ID
    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
        ordemServico.setStatus(StatusOrdemDeServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
      return ordemServicoRepository.save(ordemServico);
    }


}
