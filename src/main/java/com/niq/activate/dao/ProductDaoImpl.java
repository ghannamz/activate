package com.niq.activate.dao;

import com.niq.activate.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createOrUpdateProductMetadata(Product product) {
        entityManager.createNativeQuery("INSERT INTO products (id, category, brand)"
                        + " VALUES (?,?,?)"
                        + " ON DUPLICATE KEY UPDATE category = ?, brand = ?")
                .setParameter(1, product.getId())
                .setParameter(2, product.getCategory())
                .setParameter(3, product.getBrand())
                .setParameter(4, product.getCategory())
                .setParameter(5, product.getBrand())
                .executeUpdate();
    }
}
