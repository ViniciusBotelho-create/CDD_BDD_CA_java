package com.example.ac2.ac2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.ac2_project.ac2_ca1.Ac2CaApplication;

@ActiveProfiles("test")
@SpringBootTest(classes = Ac2CaApplication.class)
class Ac2ApplicationTests {

    @Test
    void contextLoads() {
    }
}
