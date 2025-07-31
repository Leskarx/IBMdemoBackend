package com.example.IbmDemoBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IbmDemoBackend.dto.PostDto;
import com.example.IbmDemoBackend.dto.UserDto;
import com.example.IbmDemoBackend.services.PostServices;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostServices postServices;
    
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }

    @PostMapping
    public ResponseEntity<PostDto> createUser(@RequestBody PostDto post) {
        PostDto createdPost = postServices.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
}
