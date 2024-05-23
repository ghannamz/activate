package com.niq.activate.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "shopper_personalized_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopperPersonalizedInfo implements Serializable {
    @EmbeddedId
    private ShopperPersonalizedID shopperPersonalizedId;
    @Column(name = "relevancy_score")
    private Double relevancyScore;
}
