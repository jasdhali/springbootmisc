package com.spring.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MySqlConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource ds() {
        return DataSourceBuilder.create().build();
    }

}
