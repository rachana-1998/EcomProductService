package com.rachana.EcomProductService.repository;

import com.rachana.EcomProductService.customQueries.CustomQueries;
import com.rachana.EcomProductService.module.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query(value = CustomQueries.FIND_PRODUCT_BY_TITLE)
    Category findCategoryByName(String title);

   // void findByName(String name);
}
