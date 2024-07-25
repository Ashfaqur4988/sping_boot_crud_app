package com.ecommerce.ecom_project.controller;

import com.ecommerce.ecom_project.model.Product;
import com.ecommerce.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin //to resolve the cors error
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String getHome(){
        return "Welcome to home page";
    }

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById( @PathVariable int id){

        Product product = service.getProductById(id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product){
        Product product1 = null;
        try {
            product1 = service.updateProduct(id, product);
        }
        catch (Exception e){
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
        if(product1 != null){
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("product not found", HttpStatus.NOT_FOUND);
        }
    }
}
