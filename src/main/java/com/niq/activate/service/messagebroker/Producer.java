package com.niq.activate.service.messagebroker;

import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.dto.ShopperPersonalizedProductList;

public interface Producer {
    void sendShopperPersonalizedInfo(ShopperPersonalizedProductList message);

    void sendProductMetadata(ProductMetadata message);
}
