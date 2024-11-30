package com.example.ac2_project.ac2_ca.service.test;

import com.example.ac2_project.ac2_ca.dto.UserDTO;
import com.example.ac2_project.ac2_ca.entity.User;
import com.example.ac2_project.ac2_ca.entity.UserEmail;
import com.example.ac2_project.ac2_ca.repository.UserRepository;
import com.example.ac2_project.ac2_ca.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Configurando dados fictícios
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setEmail(new UserEmail("user1@example.com"));

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setEmail(new UserEmail("user2@example.com"));

        // Mock do comportamento do repositório
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Chamada ao método de serviço
        List<UserDTO> users = userService.getAllUsers();

        // Verificação dos resultados
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getName());
        assertEquals("user1@example.com", users.get(0).getEmail());
    }
}