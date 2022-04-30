package com.project.socialnetwork.controllerTest;

import com.project.socialnetwork.dto.CreateUserRequest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

 
@QuarkusTest
public class UserControllerTeste {

	@Test
	@DisplayName("Criar um usuario com sucesso")
	public void createUserTest() {
		CreateUserRequest user = new CreateUserRequest();
		user.setName("Sasuke");
		user.setAge(40);
	
 	}

}
