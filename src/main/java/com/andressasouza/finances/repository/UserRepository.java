// CONECTA O JAVA AO BANCO DE DADOS: Camada responsável por acessar e manipular o banco de dados

package com.andressasouza.finances.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andressasouza.finances.model.User;

// Essa camada não apresenta a lógica do negócio, apenas o CRUD (COMO BUSCAR OU SALVAR NO BANCO)

public interface UserRepository extends JpaRepository<User, Long> {
    // SPRING JPA cria os SQLs baseado no nome dos métodos
    Optional<User> findByEmail(String email);

    List<User> findAll();
}
