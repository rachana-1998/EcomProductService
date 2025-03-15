package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;
import com.rachana.EcomProductService.mapper.CategoryMapper;
import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

     private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO category) {
        Category savedcategory = categoryRepository.save(CategoryMapper.categorRequestToCategory(category));
        return  CategoryMapper.categoryToCategoryResponseDTO(savedcategory);
    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID id) {
         Optional<Category> category = categoryRepository.findById(id);
          System.out.println(category);
          return  CategoryMapper.categoryToCategoryResponseDTO( null);
    }

//    @Override
//    public CategoryResponseDTO getCategoryByName(String name) {
//        categoryRepository.findByName(name);
//        return null;
//    }

    @Override
    public CategoryResponseListDTO getAllCategory() {
        return null;
    }

    @Override
    public CategoryResponseDTO updateCategoryById(UUID id, CategoryRequestDTO category) {
        return null;
    }

    @Override
    public boolean deleteCategoryById(UUID id) {
        return false;
    }
}
