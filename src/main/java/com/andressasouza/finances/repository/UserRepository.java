package com.andressasouza.finances.repository;

import java.util.List;
import java.util.Optional;

import com.andressasouza.finances.model.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    List<User> findAll();
}
