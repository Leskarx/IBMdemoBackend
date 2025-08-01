package com.example.IbmDemoBackend.mapper;

import com.example.IbmDemoBackend.dto.PostDto;
import com.example.IbmDemoBackend.entity.PostEntity;

public class PostMapper {

    public static PostDto toPostDto(PostEntity post) {
        return new PostDto(
            post.getId(),
            post.getUserId(),
            post.getTitle(),
            post.getContent(),  
            post.getCreatedAt()
        );
    }

    public static PostEntity toPostEntity(PostDto post) {
        return new PostEntity(
            post.getId(),
            post.getUserId(),
            post.getTitle(),
            post.getContent(),        
            post.getCreatedAt()
        );
    }
}

