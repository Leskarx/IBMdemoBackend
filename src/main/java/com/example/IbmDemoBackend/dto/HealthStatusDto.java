package com.example.IbmDemoBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthStatusDto {
    private String status;
    private String timestamp;
    private String message;
    
}
