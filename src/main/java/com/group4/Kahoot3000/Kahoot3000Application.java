package com.group4.Kahoot3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.sql.*;
import java.util.Locale;

@SpringBootApplication
public class Kahoot3000Application {
    public static void main(String[] args) {
        SpringApplication.run(Kahoot3000Application.class, args);
    }
}
