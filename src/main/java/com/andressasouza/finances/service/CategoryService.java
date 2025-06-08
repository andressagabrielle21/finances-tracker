package com.andressasouza.finances.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andressasouza.finances.model.Category;
import com.andressasouza.finances.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service // Identifica ao Spring que a classe é um service/Lógica da negócio
@RequiredArgsConstructor // Cria o construtor com TODOS os campos finais 
public class CategoryService {

  private final CategoryRepository categoryRepository;

  // MÉTODOS HERDADOS PELO JpaRepository
  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> listAll() {
    return categoryRepository.findAll();
  }
}
