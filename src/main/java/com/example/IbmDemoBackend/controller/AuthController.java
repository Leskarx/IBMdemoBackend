package com.example.IbmDemoBackend.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IbmDemoBackend.config.JwtUtil;
import com.example.IbmDemoBackend.dto.LoginDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    
    public AuthController(AuthenticationManager authenticationManager,JwtUtil jwtUtil){
        this.authenticationManager=authenticationManager;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        try {
             Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(),
                    loginDto.getPassword()
                )
            );

            String token = jwtUtil.generateToken(auth.getName());
            return ResponseEntity.ok(Collections.singletonMap("token", token));

            
        } catch (BadCredentialsException e) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            // TODO: handle exception
        }
    }
    
}
