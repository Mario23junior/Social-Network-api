package com.project.socialnetwork.repository;

import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.project.socialnetwork.model.Follower;
import com.project.socialnetwork.model.User;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {
 
	public boolean followsVeirific(User follower, User user) {
		
		Map<String, Object> params = Parameters.with("follower", follower)
				.and("user", user).map();
		
		PanacheQuery<Follower>  query = find("follower = :follower and user = :user",params);
		Optional<Follower> result = query.firstResultOptional();
		
		return result.isPresent();
 	}
}
