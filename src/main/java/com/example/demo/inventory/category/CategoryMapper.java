package com.example.demo.inventory.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public static CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }
    public static Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setDescription(categoryDto.getDescription());
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }

}
