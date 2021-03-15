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
import java.util.stream.Collectors;

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
    public OrdemServicoModel criar(@Valid @RequestBody OrdemServico ordemServico){
        return toModel (gestaoOrdemServicoService.criar(ordemServico));

    }

    @GetMapping
    public List<OrdemServicoModel> listar(){
        return toCollectionModel(ordemServicoRepository.findAll());
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscarPeloId(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
        if (ordemServico.isPresent()){
            OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
            return ResponseEntity.ok(ordemServicoModel);
        }
        return ResponseEntity.notFound().build();

        //ModelMapper instância o OrdemServicoModel
        // e vai aitribuir as suas propiedades no OrdemServico

    }

    private OrdemServicoModel toModel(OrdemServico ordemServico){
        return modelMapper.map(ordemServico, OrdemServicoModel.class);
    }

    //Método que lista os atributos do OrdemServicoModel
    private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> OrdensServico){
     return OrdensServico.stream()
             .map(ordemServico -> toModel(ordemServico))
             .collect(Collectors.toList());
    }



}
