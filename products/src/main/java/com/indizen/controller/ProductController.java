package com.indizen.controller;

import com.indizen.feign.ExchangeRatesConsumer;
import com.indizen.model.ExchangeRates;
import com.indizen.model.Product;
import com.indizen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getProducts() { return productService.getProducts(); }

    @GetMapping("/list/eur")
    public List<Product> getProductsEur() {
        return productService.getProductsEur();
    }

    @GetMapping("/list/usd")
    public List<Product>  getProductsUsd() {
        return productService.getProductsUsd();
    }

    @GetMapping("/list/cny")
    public List<Product>  getProductsCny() {
        return productService.getProductsCny();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) { return productService.getProduct(id); }

    @PostMapping(value="/")
    public void createProduct(@RequestBody Product product) { productService.createProduct(product); }

    @PutMapping(value="/")
    public void updateProduct(@RequestBody Product product) {   productService.updateProduct(product);   }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) { productService.deleteProduct(id); }



}
