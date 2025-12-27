package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.examly.springapp.model.Category;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    Page<Category> getCategoryPage(int page, int size);
}
