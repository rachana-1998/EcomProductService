package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.CategoryException.CategoryNotFoundException;
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
    public CategoryResponseDTO getCategoryById(UUID id) throws CategoryNotFoundException {
         Optional<Category> category = categoryRepository.findById(id);
         if(category.isEmpty()){
             throw new CategoryNotFoundException("Category does not exist for give id");
         }
         Category category1=category.get();

          return  CategoryMapper.categoryToCategoryResponseDTO( category1);
    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) throws CategoryNotFoundException {
        Category category=categoryRepository.findCategoryByName(name);
        if(category==null){
            throw new CategoryNotFoundException("category not found");
        }
        return CategoryMapper.categoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseListDTO getAllCategory() {
        List<Category> categoryList=categoryRepository.findAll();
        CategoryResponseListDTO categoryResponseDTOList= CategoryMapper.categoryListToResponseList(categoryList);
        return categoryResponseDTOList;
    }

    @Override
    public CategoryResponseDTO updateCategoryById(UUID id, CategoryRequestDTO category) throws CategoryNotFoundException {
        Optional<Category> category1=categoryRepository.findById(id);
        if(category1.isEmpty()){
            throw new CategoryNotFoundException("category is not exist on given id");
        }
        Category saveCategory=category1.get();
        saveCategory.setCategoryName(category.getName());

        return CategoryMapper.categoryToCategoryResponseDTO(saveCategory);
    }

    @Override
    public boolean deleteCategoryById(UUID id) throws CategoryNotFoundException {
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isEmpty())
        {
            throw new CategoryNotFoundException("category is not exist on given id");
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
