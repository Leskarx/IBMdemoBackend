package com.example.IbmDemoBackend.services.impl;

import java.time.Instant;
// import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.IbmDemoBackend.dto.PostDto;
import com.example.IbmDemoBackend.entity.PostEntity;
import com.example.IbmDemoBackend.entity.UserEntity;
// import com.example.IbmDemoBackend.entity.UserEntity;
import com.example.IbmDemoBackend.mapper.PostMapper;
// import com.example.IbmDemoBackend.mapper.UserMaper;
import com.example.IbmDemoBackend.repository.PostRepo;
import com.example.IbmDemoBackend.repository.UserRepo;
import com.example.IbmDemoBackend.services.PostServices;

@Service
public class PostServicesImp implements PostServices {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    

    public PostServicesImp(PostRepo postRepo,UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo=userRepo;
    }


    @Override
    public PostDto createPost(PostDto postDto) {
        // Step 1: Validate input userId
        String userId = postDto.getUserId();
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    
        // Step 2: Map DTO to Entity and set created time
        PostEntity postEntity = PostMapper.toPostEntity(postDto);
        postEntity.setCreatedAt(Instant.now());
    
        // Step 3: Save the post
        PostEntity savedPost = postRepo.save(postEntity);
    
        // Step 4: Update user's postIds
        List<String> postIds = user.getPostIds();
        if (postIds == null) {
            postIds = new ArrayList<>();
        }
        postIds.add(savedPost.getId());
        user.setPostIds(postIds);
        userRepo.save(user);
    
        // Step 5: Map back to DTO and return
        return PostMapper.toPostDto(savedPost);
    }
    


    
}
