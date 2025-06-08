package com.andressasouza.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andressasouza.finances.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  // O "JpaRepository<Category, Long>" diz ao Spring para GERENCIAR entidade CATEGORY, cuja chave primária é do tipo Long
  
  // Herda-se métodos como: save(), findById(), findAll(), delete()
}
