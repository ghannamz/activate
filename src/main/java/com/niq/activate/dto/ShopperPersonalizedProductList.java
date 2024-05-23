package com.niq.activate.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShopperPersonalizedProductList implements Serializable {
    private String shopperId;
    private List<Shelf> shelf;
}
