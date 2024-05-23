package com.niq.activate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.niq.activate.repository")
@EntityScan("com.niq.activate.model")
public class PersonalizedDataApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalizedDataApiApplication.class, args);
    }

}
