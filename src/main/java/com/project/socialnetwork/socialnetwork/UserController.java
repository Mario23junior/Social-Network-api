package com.project.socialnetwork.socialnetwork;

import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.dto.CreateUserRequest;
import com.project.socialnetwork.fieldError.ResponseErro;
import com.project.socialnetwork.model.User;
import com.project.socialnetwork.repository.UserRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
   
	
	private UserRepository repository;
	private Validator validator;
	
	@Inject
    public UserController(UserRepository repository,Validator validator) {
    	this.repository = repository;
    	this.validator = validator;
 	}
	
	@POST
	@Transactional
	public Response createUser(CreateUserRequest userRequest) {
		User user = new User();
		 
		Set<ConstraintViolation<CreateUserRequest>> validateParams = validator.validate(userRequest);
		
 		if(!validateParams.isEmpty()) {
 			 Response ResponseError = ResponseErro
 					 .createFromValidation(validateParams)
 					 .withStatusCode(ResponseErro.DEFINICIAN_STATUS_RESPONSE);
 			 return ResponseError;
  		}
		
		user.setName(userRequest.getName());
		user.setAge(userRequest.getAge());
		
		repository.persist(user);
		
		return Response
				.status(Response.Status.CREATED.getStatusCode())
				.entity(user)
				.build();
	}
	
	@GET
	public Response ListAllUsers() {
		PanacheQuery<User> query = repository.findAll();
		return Response.ok(query.list()).build();
	}
	
	@DELETE
	@Transactional
	@Path("{id}")
	public Response deleteUser(@PathParam("id") Long id) {
	  User user = repository.findById(id);
	  
	  if(user != null) {
		  repository.delete(user);
	  } else {
		  return Response.noContent().build();
	  }
	  return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@PUT
	@Transactional
	@Path("{id}")
	public Response update(@PathParam("id")Long id, CreateUserRequest userData) {
		User user =  repository.findById(id);
		
		if(user != null) {
			user.setName(userData.getName());
			user.setAge(userData.getAge());
			return Response.noContent().build();
 		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}