package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // é um conjunto de 3 anotações essencias: @Configuration, @EnableConfiguration, @ComponentScan.
// É ela que diz ao Spring Boot para escanear seu código e configurar automaticamente o servidor Tomcat.

public class ApiEscolaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiEscolaApplication.class, args);
    }
}
