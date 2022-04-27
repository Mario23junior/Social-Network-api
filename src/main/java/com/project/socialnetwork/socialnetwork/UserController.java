package com.project.socialnetwork.socialnetwork;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.dto.CreateUserRequest;
import com.project.socialnetwork.model.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
   
	@POST
	@Transactional
	public Response createUser(CreateUserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setAge(userRequest.getAge());
		
		user.persist();
		return Response.ok(user).build();
	}
	
	@GET
	public Response ListAllUsers() {
		return Response.ok().build();
	}
}
