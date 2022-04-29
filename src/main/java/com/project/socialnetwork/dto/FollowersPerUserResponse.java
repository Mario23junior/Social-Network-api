package com.project.socialnetwork.dto;

import java.util.List;

public class FollowersPerUserResponse {

	private Integer followersCount;
	private List<followersResponse> content;
	
	public FollowersPerUserResponse() {
		//TODO Auto-generated constructor stub
	}
	
	public Integer getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}
	public List<followersResponse> getContent() {
		return content;
	}
	public void setContent(List<followersResponse> content) {
		this.content = content;
	}
	
	
	

}
