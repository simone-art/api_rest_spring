package com.algaworks.osworks.apirest.model;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrdemDeServico {

    private Long id;
    private Cliente cliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemDeServico status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFinalizacao;

    /**
     * Criação dos getters and setters
     */

}
