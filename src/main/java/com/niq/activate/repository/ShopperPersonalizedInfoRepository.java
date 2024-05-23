package com.niq.activate.repository;

import com.niq.activate.model.ShopperPersonalizedID;
import com.niq.activate.model.ShopperPersonalizedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperPersonalizedInfoRepository extends JpaRepository<ShopperPersonalizedInfo,
        ShopperPersonalizedID> {
}
