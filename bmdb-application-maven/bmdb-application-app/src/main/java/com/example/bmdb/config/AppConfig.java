package com.example.bmdb.config;

import com.example.bmdb.app.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.bmdb")
@Import({DataConfig.class, InternationalizationConfig.class, PersistenceConfig.class})
public class AppConfig {

    @Bean
    public AppSpring app() {
        return new AppSpring();
    }
}
