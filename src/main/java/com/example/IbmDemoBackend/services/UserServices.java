package com.example.IbmDemoBackend.services;

import java.util.List;

import com.example.IbmDemoBackend.dto.UserDto;

public interface UserServices {
    UserDto createUser(UserDto user);
    List<UserDto> getAllUser();
    UserDto getUserById(String id);





    
}
