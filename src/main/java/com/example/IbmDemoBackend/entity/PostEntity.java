package com.example.IbmDemoBackend.entity;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
  @Id
    private String id;
    @Indexed    
    private String userId; 
    
    private String title;
    private String content;

       // ID of the user who created this post
    private Instant createdAt;


    
}
