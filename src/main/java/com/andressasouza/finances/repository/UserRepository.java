package com.andressasouza.finances.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andressasouza.finances.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // SPRING JPA cria os SQLs baseado no nome dos métodos
    Optional<User> findByEmail(String email);

    @Override
    List<User> findAll();
}
