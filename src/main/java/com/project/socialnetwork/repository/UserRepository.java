package com.project.socialnetwork.repository;

import javax.enterprise.context.ApplicationScoped;

import com.project.socialnetwork.model.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
