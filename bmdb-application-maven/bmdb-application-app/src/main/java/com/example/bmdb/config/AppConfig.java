package com.example.bmdb.config;

import com.example.bmdb.app.*;
import com.example.bmdb.service.*;
import com.example.bmdb.view.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.bmdb")
@Import({DataConfig.class, InternationalizationConfig.class, PersistenceConfig.class})
public class AppConfig {

    @Bean
    public App app() {
        return new App();
    }

    @Bean
    public ActorService actorService() {
        return new ActorService();
    }

    @Bean
    public MediaService mediaService() {
        return new MediaService();
    }

    @Bean
    public ReviewService reviewService() {
        return new ReviewService();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public CreateBasicData createBasicData() {
        return new CreateBasicData();
    }

    @Bean
    public View view() {
        return new View();
    }
}
