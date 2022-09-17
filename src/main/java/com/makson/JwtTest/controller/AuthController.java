package com.makson.JwtTest.controller;

import com.makson.JwtTest.jwt.JwtProvider;
import com.makson.JwtTest.model.User;
import com.makson.JwtTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping(value = "/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<String> authUser(@RequestBody User user) {
        String token =
                jwtProvider.generateToken(userService.findByLoginAndPassword(user.getLogin(), user.getPassword()).getLogin());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
