package com.example.IbmDemoBackend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.IbmDemoBackend.dto.UserDto;
import com.example.IbmDemoBackend.entity.UserEntity;
import com.example.IbmDemoBackend.mapper.UserMaper;
import com.example.IbmDemoBackend.repository.UserRepo;
import com.example.IbmDemoBackend.services.UserServices;

@Service
public class UserServiceImp implements UserServices {

  
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepo userRepo,PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder=passwordEncoder;
    }

    // @Override
    // public UserDto createUser(UserDto user) {
    //    UserEntity userEntity= UserMaper.toUserEntity(user);
    //    UserEntity savedUserEntity=userRepo.save(userEntity);
      
     
    //     return UserMaper.toUserDto(savedUserEntity);
    // }
    
    @Override
public UserDto createUser(UserDto user) {
    if (userRepo.existsByEmail(user.getEmail())) {
        throw new RuntimeException("Email already exists.");
    }
      // Initialize postIds list if null
      if (user.getPostIds() == null) {
        user.setPostIds(new ArrayList<>());
    }String hashedPassword=passwordEncoder.encode(user.getPassword());
    user.setPassword(hashedPassword);

    UserEntity userEntity = UserMaper.toUserEntity(user);
    UserEntity savedUserEntity = userRepo.save(userEntity);
    savedUserEntity.setPassword(null);
    return UserMaper.toUserDto(savedUserEntity);
}

    @Override
    public List<UserDto> getAllUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDto getUserById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
