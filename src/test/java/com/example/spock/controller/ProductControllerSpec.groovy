package com.example.spock.controller

import com.example.spock.repository.entity.Product
import com.example.spock.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import spock.lang.Specification

import static org.mockito.Mockito.when

@WebFluxTest(ProductController)
class ProductControllerSpec extends Specification {

    @Autowired
    WebTestClient webTestClient

    @MockitoBean
    ProductService productService

    def "GET /products/{id} returns product"() {
        given:
        when(productService.findById("P1"))
                .thenReturn(Mono.just(new Product("P1", "Phone", 799.99)))

        expect:
        webTestClient.get()
                .uri("/products/P1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath('$.name').isEqualTo("Phone")
                .jsonPath('$.price').isEqualTo(799.99)
    }

    def "GET /products returns all products"() {
        given:
        when(productService.findAll()).thenReturn(
                Flux.just(
                        new Product("P1", "Laptop", 1200),
                        new Product("P2", "Phone", 800)
                )
        )

        expect:
        webTestClient.get()
                .uri("/products")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product)
                .hasSize(2)
    }
}
