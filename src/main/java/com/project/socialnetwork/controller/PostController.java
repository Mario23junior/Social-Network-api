package com.project.socialnetwork.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.model.User;
import com.project.socialnetwork.repository.UserRepository;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {
  
	private UserRepository repository;
	
	@Inject
	public PostController(UserRepository repository) {
		this.repository = repository;
 	}
	
	@POST
	public Response savePost(@PathParam("userId") Long userId) {
		User user = repository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.CREATED).build();
	}
	
	@GET
	public Response listPost(@PathParam("userId") Long userId) {
		User user = repository.findById(userId);
	    if(user == null) {
	    	return Response.status(Response.Status.NOT_FOUND).build();
	    }
	    return Response.ok().build();
	}
}
