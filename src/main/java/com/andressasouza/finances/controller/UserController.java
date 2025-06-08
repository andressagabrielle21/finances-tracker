// ENTRADA DA APLICAÇÃO (API) | PONTO DE ENTRADA DA APLICAÇÃO: Recebe as requisições do usuário e DIRECIONA para o SERVICE.
//                             Como o graçom. Você faz o pedido, ele passa para a cozinha (SERVICE) e te entrega o pedido pronto. 
package com.andressasouza.finances.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andressasouza.finances.model.User;
import com.andressasouza.finances.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// Essa camada expõe os endpoints HTTP. Recebe requisições do usuário (API ou Frontend) e conversa com Service.

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping 
    public ResponseEntity<User> newUser(@RequestBody User user) {
        User save = UserRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @GetMapping
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
