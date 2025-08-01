package com.example.IbmDemoBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String id;
    private String userId;
    private String title;
    private String content;
    private Instant createdAt;
    
}
