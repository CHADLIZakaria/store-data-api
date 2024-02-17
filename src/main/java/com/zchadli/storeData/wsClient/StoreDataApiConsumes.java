package com.zchadli.storeData.wsClient;

import com.zchadli.storeData.model.ProductsPagination;
import com.zchadli.storeData.model.ReviewsPagination;
import com.zchadli.storeData.model.UsersPagination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "storeData", url = "https://dummyjson.com/")
public interface StoreDataApiConsumes {
    @RequestMapping(method = RequestMethod.GET, value = "products/categories")
    List<String> getGategories();

    @RequestMapping(method = RequestMethod.GET, value = "products?limit=100")
    ProductsPagination getProductPagination();

    @RequestMapping(method = RequestMethod.GET, value = "users?limit=100")
    UsersPagination getUsersPagination();

    @RequestMapping(method = RequestMethod.GET, value = "comments?limit=340")
    ReviewsPagination getComments();

}
