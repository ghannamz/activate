package com.niq.activate.dao;

import com.niq.activate.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopperProductDaoImpl implements ShopperProductDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getProductsByShopperAndFilters(String shopperId,
                                                        String category,
                                                        String brand,
                                                        Integer limit) {
        return entityManager.createNativeQuery("SELECT id, category, brand" +
                                " FROM products" +
                                " INNER JOIN shopper_personalized_info ON id = product_id" +
                                " WHERE shopper_id = ?"
//                        " AND category = ?" +
//                        " AND brand = ?" +
//                        " LIMIT ?",
                        , Product.class)
                .setParameter(1, shopperId)
                .getResultList();
    }
}
