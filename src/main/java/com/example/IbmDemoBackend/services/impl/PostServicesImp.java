package com.example.IbmDemoBackend.services.impl;

import org.springframework.stereotype.Service;

import com.example.IbmDemoBackend.dto.PostDto;
import com.example.IbmDemoBackend.entity.PostEntity;
// import com.example.IbmDemoBackend.entity.UserEntity;
import com.example.IbmDemoBackend.mapper.PostMapper;
// import com.example.IbmDemoBackend.mapper.UserMaper;
import com.example.IbmDemoBackend.repository.PostRepo;
import com.example.IbmDemoBackend.services.PostServices;

@Service
public class PostServicesImp implements PostServices {
    private final PostRepo postRepo;
    

    public PostServicesImp(PostRepo postRepo) {
        this.postRepo = postRepo;
    }


    @Override
    public PostDto createPost(PostDto post) {
          PostEntity postEntity = PostMapper.toPostEntity(post);
    PostEntity savedPostEntity =postRepo.save(postEntity);
    return PostMapper.toPostDto(savedPostEntity);
        // TODO Auto-generated method stub
        
    }


    
}
