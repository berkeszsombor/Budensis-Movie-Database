package com.example.bmdb.config;

import com.example.bmdb.Internationalizer;
import com.example.bmdb.app.*;
import com.example.bmdb.service.*;
import com.example.bmdb.view.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

    @Bean
    public App app() {
        return new App(this.createService(), this.createView());
    }

    @Bean
    public Service createService() {
        return new Service();
    }

    @Bean
    public View createView() {
        return new View(/*this.internationalizer()*/);
    }



    //@Bean
    //public MessageSource messageSource() {
    //    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    //    messageSource.addBasenames("messages/view");
    //    messageSource.setDefaultEncoding("UTF-8");
    //    return messageSource;
    //}

    //@Bean
    //public Internationalizer internationalizer() {
    //    return new Internationalizer();
    //}
}
