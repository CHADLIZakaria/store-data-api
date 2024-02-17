package com.zchadli.storeData.wsClient;

import com.zchadli.storeData.dto.CategoryDto;
import com.zchadli.storeData.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "storeData", url = "http://localhost:8080/api/")
public interface StoreDataApiProduces {
    @RequestMapping(method = RequestMethod.POST, value = "category", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void saveCategory(@RequestParam("name") String name,
                      @RequestPart("file") MultipartFile file);

    @RequestMapping(value = "/categories/search", method = RequestMethod.GET)
    List<CategoryDto> search(@RequestParam(name = "keyword", required = false) String keyword);

    @RequestMapping(method = RequestMethod.POST, value = "product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void saveProduct(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("price") double price,
                     @RequestParam("category.id") Long idCategory, @RequestParam("category.name") String categoryName, @RequestPart(name="file") MultipartFile request);
    @RequestMapping(method = RequestMethod.POST, value = "user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void saveUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("username") String username,
                    @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
                    @RequestParam("sex") String sex, @RequestParam("birthDate") String birthDate,
                    @RequestPart(name="file") MultipartFile request);

    @RequestMapping(method = RequestMethod.POST, value = "user/review")
    void saveReview(@RequestBody ReviewDto reviewDto);
}
