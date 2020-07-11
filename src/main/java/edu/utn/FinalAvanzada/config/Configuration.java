package edu.utn.FinalAvanzada.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }
}
