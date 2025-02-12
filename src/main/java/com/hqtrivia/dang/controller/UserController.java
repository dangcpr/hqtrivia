package com.hqtrivia.dang.controller;

import com.hqtrivia.dang.model.user.UserSignUpRequest;
import com.hqtrivia.dang.model.user.UserResponseSuccess;
import com.hqtrivia.dang.service.UserService;
import com.hqtrivia.dang.entity.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public UserResponseSuccess signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.signUp(userSignUpRequest);
    }

    @GetMapping
    public User sayHello() {
        return userService.sayHello();
    }
}
