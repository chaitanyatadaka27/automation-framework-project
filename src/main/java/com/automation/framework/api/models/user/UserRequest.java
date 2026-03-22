package com.automation.framework.api.models.user;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

        private String login;
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private boolean activated;
        private String langKey;
        private List<String> authorities;
        private String password;
}