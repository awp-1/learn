package com.springSecurity.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springSecurity.entity.Product;
import com.springSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to spring security";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getProducts(){

    return ResponseEntity.ok(service.getProduct().toString()).getBody();

    }

    @GetMapping("/{category}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Product> getProductByCategory(@PathVariable String category){
        return service.getProductByCategory(category);
    }


}
