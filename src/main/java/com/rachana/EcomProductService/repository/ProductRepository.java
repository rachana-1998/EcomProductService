package com.rachana.EcomProductService.repository;

import com.rachana.EcomProductService.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;



@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);
}
