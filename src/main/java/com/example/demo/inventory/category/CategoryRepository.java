package com.example.demo.inventory.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends CrudRepository<Category , Long> {
    Optional<Category> findCategoryByName(String name);
    List<Category> findAll();
}

