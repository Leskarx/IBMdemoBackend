package com.example.IbmDemoBackend.services.impl;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.IbmDemoBackend.config.JwtUtil;
import com.example.IbmDemoBackend.dto.LoginDto;
import com.example.IbmDemoBackend.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
     private final JwtUtil jwtUtil;


    public AuthServiceImpl(AuthenticationManager authenticationManager,JwtUtil jwtUtil){
        this.authenticationManager=authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @Override
    public ResponseEntity<?> login(LoginDto data) {
       

          try {
             Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    data.getEmail(),
                    data.getPassword()
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
