package com.andressasouza.finances.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DotenvConfig {
  @PostConstruct
  public void init() {
    Dotenv dotenv = Dotenv.configure().load();

    System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
    System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    System.setProperty("DB_URL", dotenv.get("DB_URL"));
  }
}
