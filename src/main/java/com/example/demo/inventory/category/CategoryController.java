package com.example.demo.inventory.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/api/categories/names")
    public List<String> getCategoryNames(){
        return categoryService.getAllCategoriesNames();
    }
}
