package com.hqtrivia.dang.service.impl;

import com.hqtrivia.dang.entity.User;

import com.hqtrivia.dang.model.user.UserExist;
import com.hqtrivia.dang.model.user.UserSignUpRequest;
import com.hqtrivia.dang.model.user.UserResponseSuccess;
import com.hqtrivia.dang.repo.user.UserRepo;
import com.hqtrivia.dang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    public UserResponseSuccess signUp(UserSignUpRequest userSignUpRequest) {
        if(userRepo.existUser(userSignUpRequest)) {
            throw new UserExist();
        }
        else {
            userRepo.addUser(userSignUpRequest);
            return userRepo.findUserByEmail(userSignUpRequest.getEmail());
        }
    }
    public User sayHello() {
//        throw new UserNotFound();

        return new User(
                1L,
                "abc",
                "123",
                "abc",
                "+84123123121",
                "abc",
                "user",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
