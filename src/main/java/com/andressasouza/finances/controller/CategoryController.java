package com.andressasouza.finances.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andressasouza.finances.model.Category;
import com.andressasouza.finances.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController // Indicará que esta classe serve para endpoints REST
@RequestMapping("/categorias") //Endereço padrão para esta rota
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping // Para criar categoria POST/categorias
    public ResponseEntity<Category> newCategory(@RequestBody Category category) {
        Category save = categoryService.newCategory(category);
        return ResponseEntity.ok(save); // Resposta HTTP 200 com a categoria salva
    }

    @GetMapping // Para listar todas categorias GET/CATEGORIAS
    public ResponseEntity<List<Category>> listAll() {
      List<Category> categories = categoryService.listAll();
      return ResponseEntity.ok(categories);
    }
}
