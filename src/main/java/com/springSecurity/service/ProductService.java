package com.springSecurity.service;

import com.springSecurity.entity.Product;
import com.springSecurity.repositoty.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProduct() {
        List<Product> responce =  repo.findAll();
        System.out.println(responce.toString());
        return responce;
    }

    public List<Product> getProductByCategory(String category) {
        return repo.findByCategory(category);
    }
}

