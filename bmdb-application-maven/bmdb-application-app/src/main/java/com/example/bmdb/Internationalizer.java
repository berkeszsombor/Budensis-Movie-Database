package com.example.bmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.Locale;

@Component
public class Internationalizer {
    @Inject
    private MessageSource messageSource;

    @Value("en")
    private Locale locale;

    public String getMessage(String s, Object... objects) {
        return this.messageSource.getMessage(s, objects, this.locale);
    }
}