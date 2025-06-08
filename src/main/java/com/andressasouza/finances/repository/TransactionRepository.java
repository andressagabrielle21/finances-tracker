package com.andressasouza.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andressasouza.finances.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
  
}
