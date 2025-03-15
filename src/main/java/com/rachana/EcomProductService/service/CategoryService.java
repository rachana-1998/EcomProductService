package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO category);

    CategoryResponseDTO getCategoryById(UUID id);

  //  CategoryResponseDTO getCategoryByName(String name);

    CategoryResponseListDTO getAllCategory();

    CategoryResponseDTO updateCategoryById(UUID id,CategoryRequestDTO category);
    boolean deleteCategoryById(UUID id);


}
