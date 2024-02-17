package com.zchadli.storeData.service;

import com.zchadli.storeData.dto.ProductDto;
import com.zchadli.storeData.dto.ReviewDto;
import com.zchadli.storeData.dto.UserDto;
import com.zchadli.storeData.model.Product;
import com.zchadli.storeData.wsClient.StoreDataApiConsumes;
import com.zchadli.storeData.wsClient.StoreDataApiProduces;
import com.zchadli.storeData.dto.CategoryDto;
import com.zchadli.storeData.helper.MultipartFileConverter;
import com.zchadli.storeData.mapper.StoreDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final StoreDataApiConsumes storeDataApiConsumes;
    private final StoreDataApiProduces storeDataApiProduces;
    private final StoreDataMapper storeDataMapper;
    public List<CategoryDto> loadCategories() {
        List<CategoryDto> categories = storeDataMapper.mapStringListToCategoryList(storeDataApiConsumes.getGategories());
        categories.forEach(categoryDto -> {
            try {
                String fileName = categoryDto.getName()+".jpg";
                String path = "upload/categories/"+fileName;
                MultipartFile file = MultipartFileConverter.convert(path, fileName);
                storeDataApiProduces.saveCategory(categoryDto.getName(), file);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return categories;
    }

    public List<ProductDto> loadProducts() {
        List<Product> products = storeDataApiConsumes.getProductPagination().getProducts();
        List<ProductDto> productDtos = storeDataMapper.toProductDtos(products);
        productDtos.forEach(productDto -> {
            CategoryDto categoryDto = storeDataApiProduces.search(productDto.getCategory().getName()).get(0);
            productDto.setCategory(categoryDto);
            String path = "upload/products/"+productDto.getId()+".jpg";
            String fileName = "product_"+productDto.getId()+".jpg";
            try {
                MultipartFileConverter.downloadUsingStream(productDto.getImagePath(), path);
                MultipartFile file = MultipartFileConverter.convert(path, fileName);
                storeDataApiProduces.saveProduct(productDto.getTitle(), productDto.getDescription(), productDto.getPrice(), productDto.getCategory().getId(),productDto.getCategory().getName(), file);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return productDtos;
    }

    public List<UserDto> loadUsers() {
        List<UserDto> users =  storeDataMapper.toUserDtos(storeDataApiConsumes.getUsersPagination().getUsers());
        users.forEach(user -> {
            String path = "upload/products/" + user.getId() + ".jpg";
            String fileName = "user_" + user.getId() + ".jpg";
            try {
                MultipartFileConverter.downloadUsingStream(user.getImagePath(), path);
                MultipartFile file = MultipartFileConverter.convert(path, fileName);
                storeDataApiProduces.saveUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(),
                        user.getEmail(), user.getPhoneNumber(), user.getSex(), user.getBirthDate(), file);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return users;
    }

    public List<ReviewDto> loadReviews() {
        List<ReviewDto> reviews =  storeDataMapper.toReviewDtos(storeDataApiConsumes.getComments().getComments());
        reviews.forEach(reviewDto -> {
            reviewDto.setRating((int)(Math.random() * 5 + 1));
            ProductDto productDto = new ProductDto();
            int productsNumber=100;
            productDto.setId((long) (Math.random() * productsNumber+1));
            reviewDto.setProduct(productDto);
            storeDataApiProduces.saveReview(reviewDto);
        });
        return reviews;
    }
}
