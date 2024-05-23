package com.niq.activate.controller;

import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.dto.ShopperPersonalizedProductList;
import com.niq.activate.service.eCommerce;
import com.niq.activate.service.messagebroker.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PersonalizedDataController {

    private final Producer producer;
    private final eCommerce eCommerce;

    @PostMapping(path = "/addShopperPersonalizedInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendShopperPersonalizedInfo(@RequestBody ShopperPersonalizedProductList shopperPersonalizedProductList) {
        producer.sendShopperPersonalizedInfo(shopperPersonalizedProductList);
    }

    @PostMapping(path = "/addProductMetadata", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendProductMetadata(@RequestBody ProductMetadata productMetadata) {
        producer.sendProductMetadata(productMetadata);
    }

    @GetMapping(path = "/products/shopper/{shopper_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductMetadata> getProductsByShopper(@PathVariable("shopper_id") final String shopperId,
                                                      @RequestParam(required = false) final String category,
                                                      @RequestParam(required = false) final String brand,
                                                      @RequestParam(required = false, defaultValue = "10") final Integer limit) {
        return eCommerce.getProductsByShopper(shopperId, category, brand, limit);
    }
}
