package com.makson.JwtTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPostDto {
    @JsonProperty("login")
    private String login;
    @JsonProperty("text")
    private String text;
}
