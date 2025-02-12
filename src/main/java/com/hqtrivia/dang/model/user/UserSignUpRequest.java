package com.hqtrivia.dang.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequest {
    private String username;
    private String password;
    private String email;
    private String phone_number;
}
