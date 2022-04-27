package com.project.socialnetwork.repository;

import javax.enterprise.context.ApplicationScoped;

import com.project.socialnetwork.model.Post;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

}
