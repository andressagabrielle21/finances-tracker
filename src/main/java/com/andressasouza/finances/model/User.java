//  OU ENTIDADES
// REPRESENTA OS DADOS: Representação do mundo real no seu sistema

package com.andressasouza.finances.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Dados que o sistema manipula. Reflexo das tabelas do banco; Molde dos dados que serão salvos no banco
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String name;
    private String email;
    private String password;
}
