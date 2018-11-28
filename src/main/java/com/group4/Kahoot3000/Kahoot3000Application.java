package com.group4.Kahoot3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@EnableConfigurationProperties
@SpringBootApplication
public class Kahoot3000Application {

    public static void main(String[] args) {
        SpringApplication.run(Kahoot3000Application.class, args);
    }

}
