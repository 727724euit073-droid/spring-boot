package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.categoryName = :name")
    List<Product> findByCategoryName(String name);

    List<Product> findByProductName(String productName);
}
