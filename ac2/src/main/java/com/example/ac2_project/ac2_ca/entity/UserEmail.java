package com.example.ac2_project.ac2_ca.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserEmail {

    private String email; // O campo de email

    
    public UserEmail() {
    }
    
    public UserEmail(String email2) {
		// TODO Auto-generated constructor stub
	}

	// Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
