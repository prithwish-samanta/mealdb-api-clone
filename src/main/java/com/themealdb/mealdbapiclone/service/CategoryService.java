package com.themealdb.mealdbapiclone.service;

import com.themealdb.mealdbapiclone.dto.CategoryDTO;
import com.themealdb.mealdbapiclone.mapper.CategoryMapper;
import com.themealdb.mealdbapiclone.model.Category;
import com.themealdb.mealdbapiclone.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> listAllMealCategories() {
        List<Category> categoryList = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "strCategory"));
        return categoryList.stream().map(CategoryMapper::convertToDTO).toList();
    }

    public Category getCategory(String category) {
        return categoryRepository.findByStrCategoryIgnoreCase(category).orElse(null);
    }
}
