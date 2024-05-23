package com.niq.activate.service;

import com.niq.activate.dto.ProductMetadata;

import java.util.List;

public interface eCommerce {
    List<ProductMetadata> getProductsByShopper(final String shopperId,
                                               final String category,
                                               final String brand,
                                               final Integer limit);
}
