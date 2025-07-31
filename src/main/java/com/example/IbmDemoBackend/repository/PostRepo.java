package com.example.IbmDemoBackend.repository;

// import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.IbmDemoBackend.entity.PostEntity;

public interface PostRepo extends MongoRepository<PostEntity,String> {
    // Optional<PostEntity> findByUserId();
    
}
