package com.example.IbmDemoBackend.controller;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IbmDemoBackend.dto.HealthStatusDto;

@RestController
@RequestMapping("/api/")
public class UserController {
    @GetMapping("health")
    public HealthStatusDto checkHealth(){
        return new HealthStatusDto(
            "up",
            Instant.now().toString(),
            "Server is running"

            
        );

    }


    @GetMapping("createUser")
    public String createUser(){
        return "hello";
    }


    

    
}
