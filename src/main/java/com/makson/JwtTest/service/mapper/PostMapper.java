package com.makson.JwtTest.service.mapper;

import com.makson.JwtTest.dto.UserPostDto;
import com.makson.JwtTest.model.UserPost;
import com.makson.JwtTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
    @Autowired
    UserService userService;

    public UserPost dtoToUserPost(UserPostDto dto) {
        UserPost entity = new UserPost();
        entity.setText(dto.getText());
        entity.setLogin(dto.getLogin());
        return entity;
    }

    public UserPostDto userPostToDto(UserPost entity) {
        UserPostDto dto = new UserPostDto();
        dto.setText(entity.getText());
        dto.setLogin(entity.getLogin());
        return dto;
    }
}
