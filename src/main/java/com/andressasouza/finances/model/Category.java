package com.andressasouza.finances.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;  // LOMBOK reduz o código repetitivo (BOILERPLATE)
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica ao Spring que esta classe será armazenada no BD
@Table(name = "CATEGORIAS") // Nome da tabela no banco
@Data // Gera getters, setters, equals, hashCode e toString automaticamente
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)  // Converte CategoryType para string
  private CategoryType type; // RECEITA OU DESPESA
}
