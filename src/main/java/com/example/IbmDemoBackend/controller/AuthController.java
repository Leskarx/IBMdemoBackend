package com.example.IbmDemoBackend.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.IbmDemoBackend.dto.LoginDto;
import com.example.IbmDemoBackend.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
   
    private final AuthService authService;
    
    public AuthController(AuthService authService){
      
        this.authService=authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){

return authService.login(loginDto);
      
    }
    
}
