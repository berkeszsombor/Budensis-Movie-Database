package com.example.bmdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/bmdb_berkes_zsombor";
    private static final String USERNAME = "bmdb_berkes_zsombor";
    private static final String PASSWORD = "Password";

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL,USERNAME, PASSWORD);
        dataSource.setDriverClassName(DRIVER);
        return dataSource;
    }
}
