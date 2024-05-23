package com.niq.activate.repository;

import com.niq.activate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}