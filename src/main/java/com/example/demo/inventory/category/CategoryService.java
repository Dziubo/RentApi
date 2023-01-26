package com.example.demo.inventory.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto getCategoryByName(String name){
        Category category = categoryRepository.findCategoryByName(name).orElseThrow(() -> {
            throw new NoSuchElementException();
        });
        return CategoryMapper.toDto(category);
    }

    public List<String> getAllCategoriesNames(){
        return categoryRepository.findAll().stream().map(Category::getName).collect(Collectors.toList());
    }
}
