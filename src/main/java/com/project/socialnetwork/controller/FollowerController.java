package com.project.socialnetwork.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.project.socialnetwork.repository.FollowerRepository;
import com.project.socialnetwork.repository.UserRepository;

@Path("/users/{userId}/followers/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerController {

	public FollowerRepository Followerepository;
	public UserRepository userRepository;
    
	@Inject
	public FollowerController(FollowerRepository followerepository,UserRepository userRepository) {
		this.Followerepository = followerepository;
		this.userRepository = userRepository;
	}
	
	

}
