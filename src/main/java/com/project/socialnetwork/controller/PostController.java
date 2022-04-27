package com.project.socialnetwork.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {
  
	@POST
	public Response  savePost() {
		return Response.status(Response.Status.CREATED).build();
	}
	
	@GET
	public Response listPost() {
		return Response.ok().build();
	}
}
