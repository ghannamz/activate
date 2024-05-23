package com.niq.activate.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shelf implements Serializable {
    private String productId;
    private Double relevancyScore;
}
