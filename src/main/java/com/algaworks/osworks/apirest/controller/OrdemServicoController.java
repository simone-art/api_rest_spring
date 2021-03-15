package com.algaworks.osworks.apirest.controller;

import com.algaworks.osworks.apirest.dto.OrdemServicoModel;
import com.algaworks.osworks.apirest.model.OrdemServico;
import com.algaworks.osworks.apirest.repository.OrdemServicoRepository;
import com.algaworks.osworks.apirest.service.GestaoOrdemServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico){
        return gestaoOrdemServicoService.criar(ordemServico);

    }

    @GetMapping
    public List<OrdemServico> listar(){
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscarPeloId(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
        if (ordemServico.isPresent()){
            OrdemServicoModel ordemServicoModel = modelMapper.map(ordemServico.get(), OrdemServicoModel.class);
            return ResponseEntity.ok(ordemServicoModel);
        }
        return ResponseEntity.notFound().build();

        //ModelMapper instância o OrdemServicoModel
        // e vai aitribuir as suas propiedades no OrdemServico
    }



}
