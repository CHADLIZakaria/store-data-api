package com.zchadli.storeData.model;

import lombok.Data;

import java.util.List;
@Data
public class ProductsPagination {
    private int total;
    private int skip;
    private int limit;
    private List<Product> products;
}
