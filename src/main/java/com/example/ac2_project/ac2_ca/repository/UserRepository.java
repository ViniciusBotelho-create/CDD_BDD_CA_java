package com.example.ac2_project.ac2_ca.repository;

import com.example.ac2_project.ac2_ca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos adicionais podem ser definidos aqui
}
