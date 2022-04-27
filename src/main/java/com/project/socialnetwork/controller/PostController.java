package com.project.socialnetwork.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.socialnetwork.dto.CreatePostRequest;
import com.project.socialnetwork.model.Post;
import com.project.socialnetwork.model.User;
import com.project.socialnetwork.repository.PostRepository;
import com.project.socialnetwork.repository.UserRepository;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {
  
	private UserRepository repository;
	private PostRepository postRepository;
	
	@Inject
	public PostController(UserRepository repository, PostRepository postRepository) {
 		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@POST
	@Transactional
	public Response savePost(@PathParam("userId") Long userId, CreatePostRequest request) {
		User user = repository.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		Post post = new Post();
		post.setText(request.getText());
 		post.setUser(user);
 
		
 		postRepository.persist(post);
 		
		return Response.status(Response.Status.CREATED).build();
	}
	

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public PostRepository getPostRepository() {
		return postRepository;
	}

	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
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
