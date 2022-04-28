package com.project.socialnetwork.repository;

import javax.enterprise.context.ApplicationScoped;

import com.project.socialnetwork.model.Follower;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {

}
