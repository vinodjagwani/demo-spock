package com.example.spock.service

import com.example.spock.repository.entity.Product
import reactor.core.publisher.Mono
import spock.lang.Specification

class ProductServiceSpec extends Specification {

    def productService = Mock(ProductService)

    def "should return product record"() {
        given:
        productService.findById("P1") >>
                Mono.just(new Product("P1", "Mock Laptop", 999.99))

        expect:
        productService.findById("P1")
                .map { it.name() }
                .block() == "Mock Laptop"
    }
}

