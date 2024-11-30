package com.example.ac2_project.ac2_ca.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2_project.ac2_ca.dto.UserDTO;
import com.example.ac2_project.ac2_ca.entity.User;
import com.example.ac2_project.ac2_ca.entity.UserEmail;
import com.example.ac2_project.ac2_ca.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(UserDTO::fromEntity)
                    .collect(Collectors.toList());
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setEmail(new UserEmail(userDTO.getEmail()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
