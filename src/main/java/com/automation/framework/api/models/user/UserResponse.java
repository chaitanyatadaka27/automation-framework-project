package com.automation.framework.api.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserResponse {

    private Long id;   // 🔥 ADD THIS

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private List<String> authorities;
}