package com.example.IbmDemoBackend.services.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.IbmDemoBackend.entity.UserEntity;
import com.example.IbmDemoBackend.repository.UserRepo;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomUserDetailsServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), new ArrayList<>()
        );
        // return new org.springframework.security.core.userdetails.User(
        //     user.getEmail(), user.getPassword(), new ArrayList<>()
        // );
    }
}