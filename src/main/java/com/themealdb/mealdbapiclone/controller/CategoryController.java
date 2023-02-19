package com.themealdb.mealdbapiclone.controller;

import com.themealdb.mealdbapiclone.dto.CategoryDTO;
import com.themealdb.mealdbapiclone.dto.ResponseDTO;
import com.themealdb.mealdbapiclone.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * List all meal categories.
     *
     * @return the response dto
     */
    @GetMapping(value = "/categories")
    public ResponseDTO<List<CategoryDTO>> listAllMealCategories() {
        List<CategoryDTO> response = categoryService.listAllMealCategories();
        return new ResponseDTO<>(response);
    }

}
