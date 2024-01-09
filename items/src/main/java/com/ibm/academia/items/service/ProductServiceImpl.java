package com.ibm.academia.items.service;

import com.ibm.academia.items.exceptions.NotFoundException;
import com.ibm.academia.items.model.Product;
import com.ibm.academia.items.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findProductById(Long id) {
        Optional<Product> productFound= repository.findById(id);
        productFound.orElseThrow(()->new NotFoundException("user with id "+id+" not found"));
        return productFound;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product, Long id) {
        Optional<Product> productFound= repository.findById(id);
        productFound.orElseThrow(()->new NotFoundException("user with id "+id+" not found"));
        Product existingProduct = productFound.get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setStock(product.getStock());
        return existingProduct;
    }
}
