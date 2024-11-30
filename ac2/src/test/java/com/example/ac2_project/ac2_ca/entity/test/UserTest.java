package com.example.ac2_project.ac2_ca.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.ac2_project.ac2_ca.entity.User;
import com.example.ac2_project.ac2_ca.entity.UserEmail;

public class UserTest {
	
	 @Test
	    void testSetAndGetValidEmail() {
	        User user = new User();
	        UserEmail email = new UserEmail("test@example.com");
	        user.setEmail(email);
	        
	        assertEquals(email, user.getEmail());
	    }

	    @Test
	    void testInvalidEmailThrowsException() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new UserEmail("invalid-email");
	        });
	    }

}
