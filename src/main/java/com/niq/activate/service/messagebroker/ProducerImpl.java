package com.niq.activate.service.messagebroker;

import com.niq.activate.dto.ProductMetadata;
import com.niq.activate.dto.ShopperPersonalizedProductList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerImpl implements Producer {
    private final JmsTemplate jmsTemplate;

    @Value("${activemq.shopper-personalized-queue}")
    private String shopperPersonalizedQueue;

    @Value("${activemq.product-metadata-queue}")
    private String productMetadataQueue;

    @Override
    public void sendShopperPersonalizedInfo(ShopperPersonalizedProductList message) {
        try {
            log.info("Attempting Send message to Queue: " + shopperPersonalizedQueue);
            jmsTemplate.convertAndSend(shopperPersonalizedQueue, message);
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
    }

    @Override
    public void sendProductMetadata(ProductMetadata message) {
        try {
            log.info("Attempting Send message to Queue: " + productMetadataQueue);
            jmsTemplate.convertAndSend(productMetadataQueue, message);
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
    }
}
