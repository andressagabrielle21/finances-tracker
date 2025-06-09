package com.andressasouza.finances.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TransactionProcedureRepository {

  private final JdbcTemplate jdbcTemplate;

  public void newTransactionViaProcedure(Long userId, Long categoryId, double value, String date_time, String description) {
    jdbcTemplate.update(connection -> {
      var callable = connection.prepareCall(" { call NEW_TRANSACTION(?, ?, ?, TO_DATE(?, 'dd/MM/yyyy'), ?) } ");
      callable.setLong(1, userId);
      callable.setLong(2, categoryId);
      callable.setDouble(3, value);
      callable.setString(4, date_time);
      callable.setString(5, description);

      return callable;
    });
  }
}
