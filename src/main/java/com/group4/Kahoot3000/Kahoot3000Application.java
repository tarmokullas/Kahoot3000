package com.group4.Kahoot3000;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableEncryptableProperties
@EnableConfigurationProperties
@SpringBootApplication
public class Kahoot3000Application {
    public static void main(String[] args) {
        SpringApplication.run(Kahoot3000Application.class, args);
    }
}
