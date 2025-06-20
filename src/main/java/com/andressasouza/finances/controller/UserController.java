
package com.andressasouza.finances.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andressasouza.finances.model.User;
import com.andressasouza.finances.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // @PostMapping 
    // public ResponseEntity<User> newUser(@RequestBody User user) {
    //     User save = UserRepository.save(user);
    //     return ResponseEntity.ok(save);
    // }

    @GetMapping
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
