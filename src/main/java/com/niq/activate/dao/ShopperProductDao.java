package com.niq.activate.dao;

import com.niq.activate.model.Product;

import java.util.List;

public interface ShopperProductDao {

    List<Product> getProductsByShopperAndFilters(String shopperId,
                                                 String category,
                                                 String brand,
                                                 Integer limit);
}
