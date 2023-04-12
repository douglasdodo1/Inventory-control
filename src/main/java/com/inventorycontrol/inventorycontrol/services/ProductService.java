package com.inventorycontrol.inventorycontrol.services;

import com.inventorycontrol.inventorycontrol.models.ProductModel;
import com.inventorycontrol.inventorycontrol.repository.ProductRepository;

import jakarta.transaction.Transactional;

public class ProductService {
    
    
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }
}
