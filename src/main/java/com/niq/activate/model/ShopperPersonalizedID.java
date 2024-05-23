package com.niq.activate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class ShopperPersonalizedID implements Serializable {
    @Column(name = "shopper_id")
    private String shopperId;
    @Column(name = "product_id")
    private String productId;
}
