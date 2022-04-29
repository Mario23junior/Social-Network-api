package com.project.socialnetwork.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.project.socialnetwork.dto.FollowerRequest;
import com.project.socialnetwork.model.Follower;
import com.project.socialnetwork.model.User;
import com.project.socialnetwork.repository.FollowerRepository;
import com.project.socialnetwork.repository.UserRepository;

@Path("/users/{userId}/followers/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerController {

	public FollowerRepository followerepository;
	public UserRepository userRepository;
    
	@Inject
	public FollowerController(FollowerRepository followerepository,UserRepository userRepository) {
		this.followerepository = followerepository;
		this.userRepository = userRepository;
	}
	
	@PUT
	@Transactional
	public Response followerUser(@PathParam("userId") Long userId ,FollowerRequest request) {
		User user = userRepository.findById(userId);
		if(user == null) {
			return Response.status(Status.NOT_FOUND).build();
		} 
		
		User follower = userRepository.findById(request.getFollowerId());
		Boolean follow =  followerepository.followsVeirific(follower, user);
		
		if(!follow) {
			Follower entity = new Follower();
			entity.setUser(user);
			entity.setFollower(follower);
			followerepository.persist(entity);			
		}    
		return Response.status(Response.Status.NO_CONTENT).build();
		
	
	}

}
