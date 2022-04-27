package com.project.socialnetwork.dto;

import java.time.LocalDateTime;

import com.project.socialnetwork.model.Post;

public class PostResponse {

	private String text;
	private LocalDateTime dateTime;

	public static PostResponse fromEntity(Post post) {
		PostResponse response = new PostResponse();
		response.setText(post.getText());
		response.setDateTime(post.getDatetime());
		return response;
	}

	public PostResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
