package com.rachana.EcomProductService.service;

import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;
import com.rachana.EcomProductService.mapper.CategoryMapper;
import com.rachana.EcomProductService.module.Category;
import com.rachana.EcomProductService.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryServiceImplTest {
   @Mock
    private CategoryRepository categoryRepository;

   @InjectMocks
    private CategoryServiceImpl categoryService;

   @BeforeEach
    public void setUp(){
    MockitoAnnotations.openMocks(this);
   }
   @Test
   void saveCategorySuccessTest(){
         //  Category category= new Category("elecrtonic");
       CategoryRequestDTO responseDTO=new CategoryRequestDTO(UUID.randomUUID(),"electronics");
       Category category= CategoryMapper.categorRequestToCategory(responseDTO);
           Mockito.when(categoryRepository.save(category)).thenReturn(category);

           CategoryResponseDTO savedCategory=categoryService.createCategory(responseDTO);
           assertNotNull(savedCategory);
           assertEquals(category.getCategoryName(),savedCategory.getName());
           assertEquals(category.getUuid(),savedCategory.getId());

   }

//    @Test
//    public void getAllCategorySuccess(){
//        List<Category> categoryList=List.of(new Category("electronics")
//                ,new Category("furniture")
//                ,new Category("HouseHold"));
//
//        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
//
//        CategoryResponseListDTO categoryResponseListDTO =categoryService.getAllCategory();
//
//
//    }



}


