// REGRAS DE NEGÓCIO (LÓGICA DO SISTEMA): Cálculos, validações, interações com mútiplos modelos ou 
//                                        chamadas a procedures. 
//                                        Decide o que pode ou não pode ser feito com os dados.
//                                        Ex: Não deixar cadastrar transação com valor negativo 

package com.andressasouza.finances.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andressasouza.finances.model.Transaction;
import com.andressasouza.finances.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    public Transaction newTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }
}
