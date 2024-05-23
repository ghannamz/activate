package com.niq.activate.mapping;

import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.dto.Shelf;
import com.niq.activate.dto.ShopperPersonalizedProductList;
import com.niq.activate.model.Product;
import com.niq.activate.model.ShopperPersonalizedID;
import com.niq.activate.model.ShopperPersonalizedInfo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MappingUtils {

    public static Product mapProductMetadataToEntity(ProductMetadata productMetadata) {
        return Product.builder()
                .id(productMetadata.getProductId())
                .category(productMetadata.getCategory())
                .brand(productMetadata.getBrand())
                .build();
    }

    public static List<ShopperPersonalizedInfo> mapShopperPersonalizedProductListToEntity(
            ShopperPersonalizedProductList shopperPersonalizedProductList) {
        List<ShopperPersonalizedInfo> shopperPersonalizedInfoList = new ArrayList<>();
        for (Shelf shelf : shopperPersonalizedProductList.getShelf()) {
            ShopperPersonalizedID id = ShopperPersonalizedID
                    .builder()
                    .shopperId(shopperPersonalizedProductList.getShopperId())
                    .productId(shelf.getProductId())
                    .build();
            ShopperPersonalizedInfo shopperPersonalizedInfo = ShopperPersonalizedInfo
                    .builder()
                    .shopperPersonalizedId(id)
                    .relevancyScore(shelf.getRelevancyScore())
                    .build();
            shopperPersonalizedInfoList.add(shopperPersonalizedInfo);
        }
        return shopperPersonalizedInfoList;
    }

    public static List<ProductMetadata> mapProductEntitiesToMetadata(Page<Product> products) {
        return products.stream().map(product -> ProductMetadata.builder()
                .productId(product.getId())
                .category(product.getCategory())
                .brand(product.getBrand())
                .build()).collect(Collectors.toList());
    }
}
