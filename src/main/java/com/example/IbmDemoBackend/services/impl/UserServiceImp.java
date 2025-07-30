package com.example.IbmDemoBackend.services.impl;

import java.util.List;



import com.example.IbmDemoBackend.dto.UserDto;
import com.example.IbmDemoBackend.repository.UserRepo;
import com.example.IbmDemoBackend.services.UserServices;

public class UserServiceImp implements UserServices {

  
    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto user) {
     
        return null;
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
