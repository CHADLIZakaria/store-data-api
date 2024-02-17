package com.zchadli.storeData.model;

import com.zchadli.storeData.dto.ProductDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadRequest {
    private MultipartFile file;
    private ProductDto product;
}
