package com.algaworks.osworks.apirest.repository;

import com.algaworks.osworks.apirest.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository é uma interfase do Spring data JPA
//<Cliente, Long > vocé tipa essa interfase colocando primeiro o tipo da entidade(Cliente)
// E o segundo é tipo do identificador, que neste caso é o ID, tipo Long
// @Repository é uma anotação que indica que essa interfase
// é um componente do Spring e ele pode ser usado em outras classes

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long > {
     List<Cliente> findByNome(String nome);
     //List<Cliente> findByNomeContaining(String nome);
}
