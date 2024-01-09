package com.ibm.academia.items.service;

import com.ibm.academia.items.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
    void deleteProductById(Long id);
    Product createProduct(Product product);

    Product updateProduct(Product product, Long id);

}
