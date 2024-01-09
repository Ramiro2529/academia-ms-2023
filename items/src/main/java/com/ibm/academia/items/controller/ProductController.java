package com.ibm.academia.items.controller;

import com.ibm.academia.items.model.Product;
import com.ibm.academia.items.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/vi/findProductById/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        Optional<Product> product=service.findProductById(id);

        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @GetMapping("/vi/findall")
    public ResponseEntity<?> findAllProducts(){
        List<Product> allProducts=service.findAllProducts();

        return new ResponseEntity<>(allProducts, HttpStatus.FOUND);
    }

    @PostMapping("/vi/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product newProduct= service.createProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/vi/deleteById")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);

        return new ResponseEntity<>("product with id "+id+" deleted", HttpStatus.OK);
    }

    @PostMapping("/vi/updateProdut/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id){
        service.updateProduct(product,id);
        return new ResponseEntity<>("product with id "+id+" updated", HttpStatus.OK);
    }
}
