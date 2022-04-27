package com.project.socialnetwork.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

 
public class CreateUserRequest {

	@NotBlank(message = "Please name is requeride")
	private String name;
	
	@NotNull(message = "Please age is required")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
