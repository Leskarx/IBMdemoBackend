package com.example.IbmDemoBackend.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IbmDemoBackend.dto.HealthStatusDto;
import com.example.IbmDemoBackend.dto.UserDto;
import com.example.IbmDemoBackend.services.UserServices;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @GetMapping("health")
    public HealthStatusDto checkHealth(){
        return new HealthStatusDto(
            "up",
            Instant.now().toString(),
            "Server is running"

            
        );

    }

@PostMapping("user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        System.out.println(user.getPassword());
        UserDto createdUser = userServices.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    

    
}
