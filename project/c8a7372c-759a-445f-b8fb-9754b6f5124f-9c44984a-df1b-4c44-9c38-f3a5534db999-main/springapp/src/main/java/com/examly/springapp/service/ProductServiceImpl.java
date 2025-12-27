package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    public Product add(Product p) { return repo.save(p); }

    public List<Product> getAll() { return repo.findAll(); }

    public Product get(Long id) { return repo.findById(id).orElse(null); }

    public Product update(Long id, Product p) {
        p.setProductId(id);
        return repo.save(p);
    }

    public List<Product> byCategory(String name) {
        return repo.findByCategoryName(name);
    }

    public List<Product> byName(String name) {
        return repo.findByProductName(name);
    }
}
