package ru.netology.jdbc.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc.repository.ProductRepository;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/api/products/fetch-product")
    public String getProductName(@RequestParam String customerName){
        return productRepository.getProductName(customerName);
    }
}
