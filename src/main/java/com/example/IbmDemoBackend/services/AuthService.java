package com.example.IbmDemoBackend.services;

import org.springframework.http.ResponseEntity;

import com.example.IbmDemoBackend.dto.LoginDto;

public interface AuthService {
    public ResponseEntity<?> login(LoginDto data);
    
}
