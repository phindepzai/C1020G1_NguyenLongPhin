package com.binzet.cart_management.service;

import com.binzet.cart_management.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
}
