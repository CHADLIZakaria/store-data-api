package com.zchadli.storeData.model;

import lombok.Data;

import java.util.List;
@Data
public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private double rating;
    private double stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;
}
