package com.zchadli.storeData.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private Long id;
    private int rating;
    private String description;
    private ProductDto product;
    private UserDto user;
    private LocalDateTime createdAt;
    private boolean isApproved;
}