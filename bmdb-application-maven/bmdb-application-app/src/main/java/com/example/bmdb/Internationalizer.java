package com.example.bmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import java.util.Locale;

public class Internationalizer {
    @Autowired
    private MessageSource messageSource;

    @Value("en")
    private Locale locale;

    public String getMessage(String s, Object... objects) {
        return this.messageSource.getMessage(s, objects, this.locale);
    }
}