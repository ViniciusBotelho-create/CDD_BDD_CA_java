package com.example.ac2_project.ac2_ca.entity;

import java.util.Objects;

import com.example.ac2_project.ac2_ca.entity.UserEmail;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserEmail {

    private String emailE; // O campo de email

    protected UserEmail() {}
    
    public UserEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.emailE = email;
    }

	// Getters e Setters
    public String getEmail() {
        return emailE;
    }

    public void setEmail(String email) {
        this.emailE = email;
    }
    
    
    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail email = (UserEmail) o;
        return Objects.equals(emailE, email.emailE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailE);
    }
}
