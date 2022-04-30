package com.project.socialnetwork.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.project.socialnetwork.dto.CreatePostRequest;
import com.project.socialnetwork.dto.PostResponse;
import com.project.socialnetwork.model.Post;
import com.project.socialnetwork.model.User;
import com.project.socialnetwork.repository.FollowerRepository;
import com.project.socialnetwork.repository.PostRepository;
import com.project.socialnetwork.repository.UserRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {

	private UserRepository repository;
	private PostRepository postRepository;
	private FollowerRepository followerRepository;

	@Inject
	public PostController(UserRepository repository, PostRepository postRepository,FollowerRepository followerRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
		this.followerRepository = followerRepository;
	}

	@POST
	@Transactional
	public Response savePost(@PathParam("userId") Long userId, CreatePostRequest request) {
		User user = repository.findById(userId);
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		Post post = new Post();
		post.setText(request.getText());
		post.setUser(user);

		postRepository.persist(post);

		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	public Response listPost(@PathParam("userId") Long userId, @HeaderParam("followerId") Long followerId) {
		User user = repository.findById(userId);
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		if(followerId == null) {
			return Response.status(Status.BAD_REQUEST)
					.entity("You are not allowed to view this information.")
					.build();
		}
		
		User follwerId = repository.findById(followerId);
		boolean followerValid = followerRepository.followsVeirific(user, user);
		
		if(!followerValid) {
			return Response.status(Status.FORBIDDEN)
					.entity("You don't follow this user so I can't see their posts")
					.build();
		}
		
		if(follwerId == null) {
			return Response.status(Status.FORBIDDEN)
					.entity("You don't follow this user so I can't see their posts")
					.build();
		}
		
		
		
		  PanacheQuery<Post> query = postRepository.find("user", Sort.by("dateTime",Direction.Descending),user);
		  List<Post> list = query.list();
		  
		  List<PostResponse> listData = list
				  .stream()
				  .map(post -> PostResponse.fromEntity(post))
				  .collect(Collectors.toList());
		  
		return Response.ok(listData).build();
	}
}
