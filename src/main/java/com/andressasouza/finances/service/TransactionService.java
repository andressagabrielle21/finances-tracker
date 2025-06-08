package com.andressasouza.finances.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.stereotype.Service;

import com.andressasouza.finances.dto.TransactionRequestDTO;
import com.andressasouza.finances.dto.TransactionResponseDTO;
import com.andressasouza.finances.model.Category;
import com.andressasouza.finances.model.Transaction;
import com.andressasouza.finances.model.User;
import com.andressasouza.finances.repository.CategoryRepository;
import com.andressasouza.finances.repository.TransactionRepository;
import com.andressasouza.finances.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    // IllegalArgumentException e EntityNotFoundException geram erros automáticos de HTTP 400/404.
    public TransactionResponseDTO newTransaction(TransactionRequestDTO dto) {
        validate(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada.") );

        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));

        Transaction transaction = new Transaction();
        transaction.setCategory(category);
        transaction.setUser(user);
        transaction.setValue(dto.getValue());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());

        Transaction newTransaction = transactionRepository.save(transaction);

        return new TransactionResponseDTO(
            newTransaction.getId(),
            category.getName(),
            newTransaction.getValue(),
            newTransaction.getDate(),
            newTransaction.getDescription()
        );
    }

    public List<TransactionResponseDTO> listAll() {
        return transactionRepository.findAll().stream()
            .map(t -> new TransactionResponseDTO(
                t.getId(),
                t.getCategory().getName(),
                t.getValue(),
                t.getDate(),
                t.getDescription()
            )).toList();
    }

    private void validate(TransactionRequestDTO transaction) {
        if (transaction.getValue() == null || transaction.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }

        if (transaction.getDate() == null) {
            throw new IllegalArgumentException("A data da transação é obrigatória.");
        }

        if (transaction.getCategory() == null || transaction.getCategory().getId() == null) {
            throw new IllegalArgumentException("Categoria é obrigatória.");
        }

        // Verifica se o usuário preenchido existe no banco
        if (transaction.getUser() == null || transaction.getUser().getId() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório.");
        }
    }
}
