package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.CategoryException.CategoryNotFoundException;
import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO category);

    CategoryResponseDTO getCategoryById(UUID id) throws CategoryNotFoundException;

  //  CategoryResponseDTO getCategoryByName(String name);

    CategoryResponseDTO getCategoryByName(String name) throws CategoryNotFoundException;

    CategoryResponseListDTO getAllCategory();

    CategoryResponseDTO updateCategoryById(UUID id,CategoryRequestDTO category) throws CategoryNotFoundException;
    boolean deleteCategoryById(UUID id) throws CategoryNotFoundException;


}
