package com.example.IbmDemoBackend.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.IbmDemoBackend.entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);

    
}
