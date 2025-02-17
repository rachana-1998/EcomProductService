package com.rachana.EcomProductService.controller;

import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;
import com.rachana.EcomProductService.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping

    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID id){

        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @GetMapping
    public ResponseEntity<CategoryResponseListDTO > getAllCategory(){
        CategoryResponseListDTO categoryList=   categoryService.getAllCategory();
        return ResponseEntity.ok(categoryList);
    }
    @PutMapping("/{id")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID id,CategoryRequestDTO category){

      return ResponseEntity.ok(categoryService.updateCategoryById(id,category));
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> deleteCategoryById(@PathVariable("id") UUID id){
       boolean isDeleted= categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
