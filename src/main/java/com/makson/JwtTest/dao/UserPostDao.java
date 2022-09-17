package com.makson.JwtTest.dao;

import com.makson.JwtTest.model.UserPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserPostDao extends CrudRepository<UserPost,Long> {
    public List<UserPost> findByLogin(String login);
}
