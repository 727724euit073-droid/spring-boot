package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Product;

public interface ProductService {
    Product add(Product p);
    List<Product> getAll();
    Product get(Long id);
    Product update(Long id, Product p);
    List<Product> byCategory(String name);
    List<Product> byName(String name);
}
