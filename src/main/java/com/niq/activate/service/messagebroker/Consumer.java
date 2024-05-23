package com.niq.activate.service.messagebroker;

import jakarta.jms.Message;

public interface Consumer {
    void readShopperPersonalizedInfoMessage(Message message);

    void readProductMetadataMessage(Message message);
}
