package com.makson.JwtTest.service;

import com.makson.JwtTest.dao.UserPostDao;
import com.makson.JwtTest.model.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostService {
    @Autowired
    UserPostDao userPostDao;

    public void savePost(UserPost userPost) {
        userPostDao.save(userPost);
    }

    public List<UserPost> getPostsByLogin(String login) {
        return userPostDao.findByLogin(login);
    }
}
