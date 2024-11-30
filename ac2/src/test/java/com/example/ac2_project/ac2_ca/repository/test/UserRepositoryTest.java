package com.example.ac2_project.ac2_ca.repository.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.example.ac2_project.ac2_ca.entity.User;
import com.example.ac2_project.ac2_ca.repository.UserRepository;
import com.example.ac2_project.ac2_ca1.Ac2CaApplication;
import com.example.ac2_project.ac2_ca.entity.UserEmail;

@ContextConfiguration(classes = {Ac2CaApplication.class})
@SpringBootTest
@ActiveProfiles("test")  // Ativa o perfil de teste
public class UserRepositoryTest {
	@Autowired
    private UserRepository userRepository;


    @Test
    void testSaveAndFindUser() {
        //Cria um objeto User com um email válido
        User user = new User();
        user.setUsername("testUser");
        user.setEmail(new UserEmail("test@example.com"));


         //Salva no banco de dados
         User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());  // Verifica se o ID foi gerado


        // Busca o usuário pelo ID
        Optional<User> retrievedUser = userRepository.findById(savedUser.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("testUser", retrievedUser.get().getUsername());
   }


}
