package com.niq.activate.service.messagebroker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niq.activate.dao.ProductDao;
import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.dto.ShopperPersonalizedProductList;
import com.niq.activate.mapping.MappingUtils;
import com.niq.activate.model.Product;
import com.niq.activate.model.ShopperPersonalizedInfo;
import com.niq.activate.repository.ShopperPersonalizedInfoRepository;
import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final ProductDao productDao;
    private final ShopperPersonalizedInfoRepository shopperPersonalizedInfoRepository;

    @Override
    @JmsListener(destination = "${activemq.shopper-personalized-queue}", containerFactory = "activateFactory")
    public void readShopperPersonalizedInfoMessage(Message message) {
        try {
            String payload = message.getBody(String.class);
            ShopperPersonalizedProductList shopperPersonalizedProductList = mapper.readValue(payload,
                    ShopperPersonalizedProductList.class);
            log.info("Received Message: " + shopperPersonalizedProductList.toString());
            if (shopperPersonalizedProductList.getShelf() == null ||
                    shopperPersonalizedProductList.getShelf().isEmpty()) {
                throw new IllegalArgumentException("Shopper shelf list is empty");
            }
            List<ShopperPersonalizedInfo> shopperPersonalizedInfoList = MappingUtils.
                    mapShopperPersonalizedProductListToEntity(shopperPersonalizedProductList);
            shopperPersonalizedInfoRepository.saveAll(shopperPersonalizedInfoList);
        } catch (Exception e) {
            log.error("Received Exception: " + e);
        }
    }

    @Override
    @JmsListener(destination = "${activemq.product-metadata-queue}", containerFactory = "activateFactory")
    public void readProductMetadataMessage(Message message) {
        try {
            String payload = message.getBody(String.class);
            ProductMetadata productMetadata = mapper.readValue(payload, ProductMetadata.class);
            log.info("Received Message: " + productMetadata.toString());
            Product product = MappingUtils.mapProductMetadataToEntity(productMetadata);
            productDao.createOrUpdateProductMetadata(product);
        } catch (Exception e) {
            log.error("Received Exception: " + e);
        }
    }
}
