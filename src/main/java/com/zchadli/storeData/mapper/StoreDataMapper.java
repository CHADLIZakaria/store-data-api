package com.zchadli.storeData.mapper;

import com.zchadli.storeData.dto.CategoryDto;
import com.zchadli.storeData.dto.ProductDto;
import com.zchadli.storeData.dto.ReviewDto;
import com.zchadli.storeData.dto.UserDto;
import com.zchadli.storeData.model.Product;
import com.zchadli.storeData.model.Review;
import com.zchadli.storeData.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StoreDataMapper {
    @Mapping(source = "category", target = "name")
    CategoryDto mapStringToCategory(String category);
    default List<CategoryDto> mapStringListToCategoryList(List<String> stringList) {
        return stringList.stream().map(this::mapStringToCategory).collect(Collectors.toList());
    }
    @Mapping(source = "thumbnail", target = "imagePath")
    ProductDto toProductDto(Product product);
    List<ProductDto> toProductDtos(List<Product> products);

    @Mapping(source = "phone", target = "phoneNumber")
    @Mapping(source = "gender", target = "sex")
    @Mapping(source = "image", target = "imagePath")
    UserDto toUserDto(User user);
    List<UserDto> toUserDtos(List<User> user);

    @Mapping(source = "body", target = "description")
    ReviewDto toReviewDto(Review review);


    @Mapping(source = "body", target = "description")
    List<ReviewDto> toReviewDtos(List<Review> review);
}
