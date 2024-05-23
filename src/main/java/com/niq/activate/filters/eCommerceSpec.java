package com.niq.activate.filters;

import com.niq.activate.model.Product;
import com.niq.activate.model.ShopperPersonalizedID;
import com.niq.activate.model.ShopperPersonalizedInfo;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class eCommerceSpec {
    private static final String CATEGORY = "category";
    private static final String BRAND = "brand";

    private static Specification<Product> hasCategory(String category) {
        return (root, query, cb) -> category == null || category.isEmpty() ? cb.conjunction() : cb.equal(root.get(CATEGORY), category);
    }

    private static Specification<Product> hasBrand(String brand) {
        return (root, query, cb) -> brand == null || brand.isEmpty() ? cb.conjunction() : cb.equal(root.get(BRAND), brand);
    }

    private static Specification<Product> hasShopperId(String shopperId) {
        return (root, query, cb) -> {
            Join<Product, ShopperPersonalizedInfo> firstJoin = root.join("shopperPersonalizedInfoList");
            Join<ShopperPersonalizedInfo, ShopperPersonalizedID> secondJoin = firstJoin.join("shopperPersonalizedId");
            return cb.equal(secondJoin.get("shopperId"), shopperId);
        };
    }

    public static Specification<Product> filterBy(String shopperId, String category, String brand) {
        return hasShopperId(shopperId)
                .and(hasCategory(category))
                .and(hasBrand(brand));
    }
}
