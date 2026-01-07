package com.example.spock.service;

import com.example.spock.repository.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    public Mono<Product> findById(String id) {
        return Mono.just(
                new Product(id, "Laptop", 1200.00)
        );
    }

    public Flux<Product> findAll() {
        return Flux.just(
                new Product("P1", "Laptop", 1200.00),
                new Product("P2", "Phone", 800.00),
                new Product("P3", "Tablet", 500.00)
        );
    }
}
