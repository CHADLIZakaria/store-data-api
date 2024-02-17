package com.zchadli.storeData.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String imagePath;
    private CategoryDto category;
}
