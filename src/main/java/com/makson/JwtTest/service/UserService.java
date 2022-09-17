package com.makson.JwtTest.service;

import com.makson.JwtTest.dao.RoleDao;
import com.makson.JwtTest.dao.UserDao;
import com.makson.JwtTest.model.Role;
import com.makson.JwtTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user) {
        Role userRole = roleDao.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = userDao.findByLogin(login);
        if (user != null || passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
