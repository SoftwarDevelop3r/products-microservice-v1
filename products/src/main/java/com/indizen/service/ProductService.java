package com.indizen.service;

import com.indizen.feign.ExchangeRatesConsumer;
import com.indizen.model.ExchangeRates;
import com.indizen.model.Product;
import com.indizen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExchangeRatesConsumer exchangeRatesConsumer;

    public List<Product> getProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProduct(long id){
        return productRepository.findById(id);
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsEur(){

        float price = getPriceByCurrency("EUR");
        List<Product> eurProducts = getProductsByPrice(price);

        return eurProducts;
    }

    public List<Product> getProductsUsd(){

        float price = getPriceByCurrency("USD");
        List<Product> usdProducts = getProductsByPrice(price);

        return usdProducts;
    }

    public List<Product> getProductsCny(){

        float price = getPriceByCurrency("CNY");
        List<Product> cnyProducts = getProductsByPrice(price);

        return cnyProducts;
    }

    public float getPriceByCurrency(String currency){
        float price = 1;

        List<ExchangeRates> exchangeRates = exchangeRatesConsumer.getExchangeRates();
        Iterator<ExchangeRates> it = exchangeRates.iterator();
        while (it.hasNext()) {
            ExchangeRates exchangeRate = it.next();
            if (exchangeRate.getCurrency().equals(currency)){
                price = exchangeRate.getPrice();
            }
        }

        return price;
    }

    public List<Product> getProductsByPrice(float price){
        List<Product> products = (List<Product>) productRepository.findAll();
        List<Product> productsByNewPrice = new ArrayList<>();

        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            Product productByNewPrice = new Product(product.getId(), product.getName(), product.getDescription(), product.getPrice()*price);
            if (productByNewPrice != null){
                productsByNewPrice.add(productByNewPrice);
            }

        }

        return productsByNewPrice;
    }

}
