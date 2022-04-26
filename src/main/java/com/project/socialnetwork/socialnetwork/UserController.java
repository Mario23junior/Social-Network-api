package com.project.socialnetwork.socialnetwork;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.dto.CreateUserRequest;

@Path("/users")
public class UserController {
   
	@POST
	public Response createUser(CreateUserRequest userRequest) {
		return Response.ok().build();
	}
}
