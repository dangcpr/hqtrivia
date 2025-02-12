package com.hqtrivia.dang.service;

import com.hqtrivia.dang.entity.User;
import com.hqtrivia.dang.model.user.UserResponseSuccess;
import com.hqtrivia.dang.model.user.UserSignUpRequest;

public interface UserService {
    UserResponseSuccess signUp(UserSignUpRequest userSignUpRequest);
    User sayHello();
}
