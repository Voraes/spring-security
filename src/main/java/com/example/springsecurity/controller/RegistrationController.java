package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.event.RegistrationCompleteEvent;
import com.example.springsecurity.model.UserModel;
import com.example.springsecurity.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final UserService userService;

    private ApplicationEventPublisher publisher;

    public RegistrationController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, "url"));
        return "Registered";
    }
}
