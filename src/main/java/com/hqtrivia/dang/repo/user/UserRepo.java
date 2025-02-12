package com.hqtrivia.dang.repo.user;

import com.hqtrivia.dang.model.user.UserSignUpRequest;
import com.hqtrivia.dang.model.user.UserResponseSuccess;

public interface UserRepo {
    void addUser(UserSignUpRequest userSignUpRequest);
    boolean existUser(UserSignUpRequest userSignUpRequest);
    boolean existUserByEmail(String email);
    boolean existUserByUsername(String username);
    boolean existUserByPhoneNumber(String phone_number);
    UserResponseSuccess findUserByEmail(String email);
}
