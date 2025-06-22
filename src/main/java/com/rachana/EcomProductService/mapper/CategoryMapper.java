package com.rachana.EcomProductService.mapper;

import com.rachana.EcomProductService.dto.request.CategoryRequestDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;
import com.rachana.EcomProductService.module.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class CategoryMapper {
    public static Category categorRequestToCategory(CategoryRequestDTO categoryDTO){
        Category category=new Category();
        category.setCategoryName(categoryDTO.getName());
        category.setUuid(categoryDTO.getId());
        return category;
    }

    public static CategoryResponseDTO categoryToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getUuid());
        categoryResponseDTO.setName(category.getCategoryName());
        return categoryResponseDTO;
    }

    public static CategoryResponseListDTO categoryListToResponseList(List<Category> categories){
        CategoryResponseListDTO responseListDTO=new CategoryResponseListDTO();
        for(Category category:categories){
            CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
            categoryResponseDTO.setId(category.getUuid());
            categoryResponseDTO.setName(category.getCategoryName());
             responseListDTO.getCategoryList().add(categoryResponseDTO);
        }
        return responseListDTO;
    }

}
