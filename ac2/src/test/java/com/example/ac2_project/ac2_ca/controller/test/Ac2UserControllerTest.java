package com.example.ac2_project.ac2_ca.controller.test;

import com.example.ac2_project.ac2_ca.controller.UserController;
import com.example.ac2_project.ac2_ca.dto.UserDTO;
import com.example.ac2_project.ac2_ca.service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test") // Usa o perfil 'test' definido
@WebMvcTest(controllers = UserController.class) // Configura apenas a camada web com o controlador
public class Ac2UserControllerTest {

    @Autowired
    private MockMvc mockMvc; // Mock para simular requisições HTTP

    @MockBean
    private UserService userService; // Mock do serviço injetado no UserController

    @Test
    public void testGetUsers() throws Exception {
        // Configura o comportamento do mock para o método de serviço
        UserDTO mockUser = new UserDTO();
        mockUser.setId(1L);
        mockUser.setName("Alberto");
        mockUser.setEmail("alberto@example.com");

        List<UserDTO> mockUsers = List.of(mockUser);
        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers); // Define o comportamento simulado

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alberto"))
                .andExpect(jsonPath("$[0].email").value("alberto@example.com"));
    }
}
