package com.andressasouza.finances.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDTO {

  // userId e categoryId chegam como IDs simples, não como obejtos complexos

  @NotNull(message= "O ID do usuário é obrigatório.")
  private Long userId;

  @NotNull(message= "O ID da categoria é obrigatório.")
  private Long categoryId;

  @NotNull(message= "O valor é obrigatório.")
  @DecimalMin(value = "0.01", message= "O valor deve ser maior que zero.")
  private BigDecimal value;

  @NotNull(message="A data da transação é obrigatória.")
  private LocalDate date;

  @Size(max= 200, message="A descrição deve ter no máximo 200 caracteres.")
  private String description;

}
