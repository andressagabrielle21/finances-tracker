package com.andressasouza.finances.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACOES")
@Data
@NoArgsConstructor
@AllArgsConstructor
// TRANSAÇÃO DEPENDE DE UM USUÁRIO E UMA CATEGORIA
public class Transaction {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @ManyToOne // RELAÇÃO: Muitas transações para um usuário
  //  Ao salvar uma transação, se está ligando automaticamente a um usuário existente, o JPA irá associar automaticamente a chave estrangeira
  @JoinColumn(name= "user_id")
  private User user;

  @ManyToOne // Muitas transações para uma categoria (FAZER)
  @JoinColumn(name= "category_id")
  private Category category;

  private BigDecimal value; // BigDecimal para precisão financeira

  private LocalDate dateTime;

  private String description;

}
