package com.springSecurity.service;

import com.springSecurity.entity.Product;
import com.springSecurity.entity.UserInfo;
import com.springSecurity.repositoty.ProductRepository;
import com.springSecurity.repositoty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Product> getProduct() {
        List<Product> responce =  repo.findAll();
        System.out.println(responce.toString());
        return responce;
    }

    public List<Product> getProductByCategory(String category) {
        return repo.findByCategory(category);
    }

    public String addNewUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        System.out.println(userInfo.getUsername());
        userRepo.save(userInfo);
        return "New user added.";
    }
}

