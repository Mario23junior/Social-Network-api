package com.project.socialnetwork.dto;

import com.project.socialnetwork.model.Follower;

public class followersResponse {
    
	private Long id;
	private String name;
	
	
	public followersResponse(Long id, String name) {
		this.id = id;
		this.name = name;
 	}
	
	public followersResponse(Follower followe) {
		this(followe.getId(), 
			 followe.getFollower().getName());
 	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
