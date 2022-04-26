package com.project.socialnetwork.socialnetwork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.dto.CreateUserRequest;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
   
	@POST
	public Response createUser(CreateUserRequest userRequest) {
		return Response.ok(userRequest).build();
	}
	
	@GET
	public Response ListAllUsers() {
		return Response.ok().build();
	}
}
