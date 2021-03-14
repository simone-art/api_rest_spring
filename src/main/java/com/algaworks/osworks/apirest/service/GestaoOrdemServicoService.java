package com.algaworks.osworks.apirest.service;

import com.algaworks.osworks.apirest.model.OrdemServico;
import com.algaworks.osworks.apirest.model.StatusOrdemDeServico;
import com.algaworks.osworks.apirest.repository.OrdemServicoRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemDeServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
      return ordemServicoRepository.save(ordemServico);
    }


}
