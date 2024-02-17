package com.zchadli.storeData.model;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private String body;
    private Long postId;
    private UserReview user;
}
