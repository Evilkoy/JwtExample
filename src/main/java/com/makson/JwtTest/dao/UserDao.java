package com.makson.JwtTest.dao;

import com.makson.JwtTest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    User findByLogin(String login);
}
