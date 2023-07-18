package com.example.springsecurity.event.listener;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create Verification Token for User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        //Send Email to User
    }
}
