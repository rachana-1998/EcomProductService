package com.rachana.EcomProductService.repository;

import com.rachana.EcomProductService.module.ProductOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface OrdersRepository extends JpaRepository<ProductOrders, UUID> {
}
