package com.andressasouza.finances.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andressasouza.finances.dto.TransactionRequestDTO;
import com.andressasouza.finances.dto.TransactionResponseDTO;
import com.andressasouza.finances.service.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransactionController {
  
  private final TransactionService transactionService;

  @PostMapping 
  public ResponseEntity<TransactionResponseDTO> newTransaction(@RequestBody @Valid TransactionRequestDTO dto) {
    TransactionResponseDTO response = transactionService.newTransaction(dto);
    return ResponseEntity.ok(response);
  } 

  @GetMapping
  public ResponseEntity<List<TransactionResponseDTO>> listAll() {
    List<TransactionResponseDTO> transactions = transactionService.listAll();
    return ResponseEntity.ok(transactions);
  }
}
