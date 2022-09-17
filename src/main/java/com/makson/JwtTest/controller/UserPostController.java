package com.makson.JwtTest.controller;

import com.makson.JwtTest.dto.UserPostDto;
import com.makson.JwtTest.service.UserPostService;
import com.makson.JwtTest.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserPostController {
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserPostService userPostService;

    @PostMapping(value = "/post")
    public ResponseEntity<HttpStatus> addPost(@RequestBody UserPostDto userPostDto) {
        userPostService.savePost(postMapper.dtoToUserPost(userPostDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getposts/{login}")
    public ResponseEntity<List<UserPostDto>> getPosts(@PathVariable String login) {
        List<UserPostDto> posts =
                userPostService.getPostsByLogin(login).stream()
                        .map(userPost -> postMapper.userPostToDto(userPost))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
