package com.niq.activate.dao;

import com.niq.activate.model.Product;

public interface ProductDao {
    void createOrUpdateProductMetadata(Product product);
}
