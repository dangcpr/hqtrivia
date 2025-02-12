package com.hqtrivia.dang.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequest {
    private String username;
    private String password;
}
