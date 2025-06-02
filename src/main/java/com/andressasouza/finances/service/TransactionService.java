package com.andressasouza.finances.service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Types;

import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final JdbcTemplate jdbcTemplate;

    public BigDecimal getBalance(Long userId) {
        return jdbcTemplate.execute(
        (ConnectionCallback<BigDecimal> -> {
            CallableStatement stmt = conn.prepareCall("? = call OBTER_SALDO_POR_USUARIO");
            stmt.registerOutParameter(1, Types.NUMERIC);
            stmt.setLong()
        
        })
        );
    }
}
