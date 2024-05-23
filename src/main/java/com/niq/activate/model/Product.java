package com.niq.activate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    private String id;
    private String category;
    private String brand;
    @OneToMany(mappedBy = "shopperPersonalizedId.productId")
    private List<ShopperPersonalizedInfo> shopperPersonalizedInfoList;
}
