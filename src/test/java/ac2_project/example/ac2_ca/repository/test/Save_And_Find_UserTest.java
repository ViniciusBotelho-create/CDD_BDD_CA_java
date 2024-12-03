package ac2_project.example.ac2_ca.repository.test;

import com.example.ac2_project.ac2_ca.entity.User;
import com.example.ac2_project.ac2_ca.repository.UserRepository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.example.ac2_project.ac2_ca1.Ac2CaApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = {Ac2CaApplication.class})
@DataJpaTest  // Teste focado no repositório JPA
@ActiveProfiles("test")  // Ativa o perfil de teste
public class Save_And_Find_UserTest {

    @Autowired
    private UserRepository userRepository; // O repositório que será testado

    @Test
    public void testSaveAndFindUser() {
        // Cria um novo usuário para ser salvo no banco de dados
        User user = new User();
        user.setUsername("testUser1");

        // Salva o usuário no banco de dados
        User savedUser = userRepository.save(user);

        // Verifica se o usuário foi salvo com um ID não nulo (significa que foi persistido no banco)
        assertNotNull(savedUser.getId());

        // Busca o usuário pelo ID e verifica se ele foi encontrado
        Optional<User> retrievedUser = userRepository.findById(savedUser.getId());

        // Verifica se o usuário foi encontrado e se o nome de usuário é o mesmo
        assertThat(retrievedUser).isPresent();
        assertThat(retrievedUser.get().getUsername()).isEqualTo("testUser1");
    }
}
