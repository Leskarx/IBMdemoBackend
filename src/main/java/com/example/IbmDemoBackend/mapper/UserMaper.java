package com.example.IbmDemoBackend.mapper;

import com.example.IbmDemoBackend.dto.UserDto;
import com.example.IbmDemoBackend.entity.UserEntity;

public class UserMaper {
    public  static UserDto toUserDto(UserEntity user){
        return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPostIds());

    }

    public static UserEntity toUserEntity(UserDto user){
        return new UserEntity(user.getId(),user.getName(),user.getEmail(),null,user.getPostIds());

    }

    
}
