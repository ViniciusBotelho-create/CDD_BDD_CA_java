package com.example.ac2_project.ac2_ca1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;


@SpringBootApplication(scanBasePackages = "com.example.ac2_project")
@EntityScan("com.example.ac2_project.ac2_ca.entity")  // Ensure all packages are scanned
@EnableJpaRepositories("com.example.ac2_project.ac2_ca.repository")
@Controller

public class Ac2CaApplication {
    public static void main(String[] args) {
        SpringApplication.run(Ac2CaApplication.class, args);
    }
}