package com.example.ac2_project.ac2_ca.entity;

import java.util.Objects;

import com.example.ac2_project.ac2_ca.entity.UserEmail;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserEmail {

    private String email_E;

    // Construtor padrão necessário para o JPA
    protected UserEmail() {}

    public UserEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email_E = email;
    }

    public String getEmailAddress() {
        return email_E;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail email = (UserEmail) o;
        return Objects.equals(email_E, email.email_E);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email_E);
    }

	
}
