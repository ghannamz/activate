package com.niq.activate.model;

import jakarta.persistence.*;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShopperPersonalizedInfo> shopperPersonalizedInfoList;
}
