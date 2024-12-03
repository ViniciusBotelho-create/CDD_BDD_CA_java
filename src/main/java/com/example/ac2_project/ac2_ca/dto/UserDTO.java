package com.example.ac2_project.ac2_ca.dto;

import com.example.ac2_project.ac2_ca.dto.UserDTO;
import com.example.ac2_project.ac2_ca.entity.User;

 
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    
    // Construtor vazio
    public UserDTO() {}
    
    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

	// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
 // Método de conversão de User para UserDTO
    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getUsername());

        if (user.getEmail() != null) {
            userDTO.setEmail(user.getEmail().getEmailAddress());
        }

        return userDTO;
    }
}
