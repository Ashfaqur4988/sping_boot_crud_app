package com.ecommerce.ecom_project.service;

import com.ecommerce.ecom_project.model.Product;
import com.ecommerce.ecom_project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }


    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
