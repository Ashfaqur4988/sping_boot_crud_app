package com.ecommerce.ecom_project.repository;

import com.ecommerce.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


}
