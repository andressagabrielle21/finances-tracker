package com.andressasouza.finances.repository;

import java.util.Optional;

import com.andressasouza.finances.model.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
