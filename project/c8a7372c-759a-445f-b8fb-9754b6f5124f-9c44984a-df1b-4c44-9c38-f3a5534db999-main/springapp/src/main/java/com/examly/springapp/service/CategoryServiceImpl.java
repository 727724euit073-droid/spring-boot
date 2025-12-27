package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo repo;

    public Category addCategory(Category c) { return repo.save(c); }

    public List<Category> getAllCategories() { return repo.findAll(); }

    public Category getCategoryById(Long id) { return repo.findById(id).orElse(null); }

    public Category updateCategory(Long id, Category c) {
        c.setCategoryId(id);
        return repo.save(c);
    }

    public Page<Category> getCategoryPage(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
