package com.rachana.EcomProductService.cntroller;


import com.rachana.EcomProductService.controller.CategoryController;
import com.rachana.EcomProductService.dto.response.CategoryResponseDTO;
import com.rachana.EcomProductService.dto.response.CategoryResponseListDTO;
import com.rachana.EcomProductService.service.CategoryService;
import com.rachana.EcomProductService.service.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void getAllCategorySuccess() throws Exception {
        CategoryResponseListDTO categoryResponseListDTO= new CategoryResponseListDTO();

        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO(UUID.randomUUID(),"Electronics");
        CategoryResponseDTO categoryResponseDTO1=new CategoryResponseDTO(UUID.randomUUID(),"House Hold");
        CategoryResponseDTO categoryResponseDTO2=new CategoryResponseDTO(UUID.randomUUID(),"furniture");
        categoryResponseListDTO.setCategoryList(List.of(categoryResponseDTO,categoryResponseDTO1,categoryResponseDTO2));
        mockMvc.perform(get("/category"))
          .andExpect(status().is(200))
          .andExpect(content().string("[]"));
    }
}
