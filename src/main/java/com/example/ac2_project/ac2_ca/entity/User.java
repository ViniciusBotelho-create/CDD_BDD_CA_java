package com.example.ac2_project.ac2_ca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id; // Identificador único

    private String username; // Nome de usuário

    @Embedded
    private UserEmail email; // Objeto de Valor: Email (ajustado para UserEmail)

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserEmail getEmail() {
        return email;
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }
}
