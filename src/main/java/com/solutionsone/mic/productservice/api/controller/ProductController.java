package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.application.usercase.impl.ProductProducer;
import com.solutionsone.mic.productservice.domain.entity.Product2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductProducer productProducer;

    @PostMapping("/publish")
    public String publishProduct(@RequestBody Product2 product) {
        productProducer.sendProduct(product);
        return "Message sent to Kafka topic";
    }
}
