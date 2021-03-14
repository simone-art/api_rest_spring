package com.algaworks.osworks.apirest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class OrdemServico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Valid anotação que faz o efeito cascata e lê todos os atributos desta classe
    //para certificar que não estejam nulos
    //@ManyToOne indica que muitas ordem só podem ser feitas por un único cliente pego pelo ID
    @Valid
    //@ConvertGroup(from = Default.class, to = yyy)
    @NotNull
    @ManyToOne
    private Cliente cliente;

   @NotBlank
    private String descricao;
   @NotNull
    private BigDecimal preco;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrdemDeServico status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataAbertura;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;

    /**
     * Criação dos getters and setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public StatusOrdemDeServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemDeServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    /**
     * Criação hasCode and equals só para o ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
