package com.zchadli.storeData.controller;

import com.zchadli.storeData.dto.CategoryDto;
import com.zchadli.storeData.dto.ProductDto;
import com.zchadli.storeData.dto.ReviewDto;
import com.zchadli.storeData.dto.UserDto;
import com.zchadli.storeData.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value="/")
public class StoreDataController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(value="categories")
    public List<CategoryDto> loadCaategories() {
        List<CategoryDto> categories = categoryService.loadCategories();
        return categories;
    }

    @GetMapping(value="products")
    public List<ProductDto> loadProducts() {
        List<ProductDto> products = categoryService.loadProducts();
        return products;
    }

    @GetMapping(value="users")
    public List<UserDto> loadUsers() {
        List<UserDto> products = categoryService.loadUsers();
        return products;
    }

    @GetMapping(value="reviews")
    public List<ReviewDto> loadReviews() {
        List<ReviewDto> products = categoryService.loadReviews();
        return products;
    }
}
