package org.prgrms.kdt.musinsaserviceclone.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prgrms.kdt.musinsaserviceclone.domain.Category;
import org.prgrms.kdt.musinsaserviceclone.domain.Order;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        product = Product.builder()
                .name("레이어드 크루 넥 반팔 티셔츠_일반 기장 [화이트]")
                .category(Category.TOP)
                .price(16900)
                .description("여유 있는 레귤러 핏의 레이어드 크루 넥 반팔 티셔츠_일반 기장.")
                .build();
        productRepository.save(product);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void 상품을_조회한다() {
        // When
        Optional<Product> fetchedProduct = productRepository.findById(product.getId());

        // Then
        assertThat(fetchedProduct).isNotEmpty();
        assertThat(fetchedProduct.get().getId()).isEqualTo(product.getId());
    }

    @Test
    void 상품을_수정한다() {
        // When
        product.setName("레이어드 크루 넥 반팔 티셔츠_일반 기장 [블랙]");
        productRepository.save(product);

        // Then
        Product fetchedProduct = productRepository.findById(product.getId()).get();
        assertThat(fetchedProduct.getName()).isEqualTo(product.getName());
    }

    @Test
    void 상품을_삭제한다() {
        // When
        productRepository.deleteById(product.getId());

        // Then
        Optional<Product> fetchedProduct = productRepository.findById(product.getId());
        assertThat(fetchedProduct).isEmpty();
    }
}