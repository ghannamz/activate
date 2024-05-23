package com.niq.activate.service;

import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.filters.eCommerceSpec;
import com.niq.activate.mapping.MappingUtils;
import com.niq.activate.model.Product;
import com.niq.activate.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class eCommerceImpl implements eCommerce {

    private final ProductRepository productRepository;

    @Override
    public List<ProductMetadata> getProductsByShopper(String shopperId,
                                                      String category,
                                                      String brand,
                                                      Integer limit) {
        log.info("Get products by shopper id: " + shopperId);
        Specification<Product> productSpecification = eCommerceSpec.filterBy(shopperId, category, brand);
        Page<Product> products = productRepository.findAll(productSpecification, PageRequest.ofSize(limit > 100 ? 100 : limit));
        return MappingUtils.mapProductEntitiesToMetadata(products);
    }
}
