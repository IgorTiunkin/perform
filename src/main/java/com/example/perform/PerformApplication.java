package com.example.perform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class PerformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformApplication.class, args);
    }

}
