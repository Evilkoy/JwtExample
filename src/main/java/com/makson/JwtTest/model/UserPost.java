package com.makson.JwtTest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@Data
public class UserPost extends BaseEntity {
    @Column(name = "login")
    private String login;
    @Column(name = "text")
    private String text;
}
