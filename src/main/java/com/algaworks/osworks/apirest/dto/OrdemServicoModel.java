package com.algaworks.osworks.apirest.dto;

import com.algaworks.osworks.apirest.model.StatusOrdemDeServico;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrdemServicoModel {

    private Long id;
    private String nomeCliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemDeServico statusOrdemDeServico;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;

    /**
     * Criação  Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemDeServico getStatusOrdemDeServico() {
        return statusOrdemDeServico;
    }

    public void setStatusOrdemDeServico(StatusOrdemDeServico statusOrdemDeServico) {
        this.statusOrdemDeServico = statusOrdemDeServico;
    }

    public OffsetDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(OffsetDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public OffsetDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
