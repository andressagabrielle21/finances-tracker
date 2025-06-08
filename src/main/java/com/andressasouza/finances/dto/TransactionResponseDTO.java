package com.andressasouza.finances.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponseDTO {
  private Long id;
  private String categoryName;
  private BigDecimal value;
  private LocalDate date;
  private String description;
}
