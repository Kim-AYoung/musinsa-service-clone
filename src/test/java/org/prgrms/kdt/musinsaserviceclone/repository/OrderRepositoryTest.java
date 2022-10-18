package org.prgrms.kdt.musinsaserviceclone.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prgrms.kdt.musinsaserviceclone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    private Order order;

    @BeforeEach
    void setUp() {
        Product product = Product.builder()
                .name("레이어드 크루 넥 반팔 티셔츠_일반 기장 [화이트]")
                .category(Category.TOP)
                .price(16900)
                .description("여유 있는 레귤러 핏의 레이어드 크루 넥 반팔 티셔츠_일반 기장.")
                .build();
        productRepository.save(product);

        order = Order.builder()
                .address("대전광역시")
                .orderStatus(OrderStatus.ACCEPTED)
                .build();
        order.addOrderProduct(
                OrderProduct.builder()
                        .product(product)
                        .order(order)
                        .quantity(2)
                        .build()
        );
        orderRepository.save(order);
    }

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void 주문을_조회한다() {
        // When
        Optional<Order> fetchedOrder = orderRepository.findById(order.getId());

        // Then
        assertThat(fetchedOrder).isNotEmpty();
        assertThat(fetchedOrder.get().getId()).isEqualTo(order.getId());
    }

    @Test
    void 주문을_수정한다() {
        // When
        order.setAddress("서울특별시");
        orderRepository.save(order);

        // Then
        Order fetchedOrder = orderRepository.findById(order.getId()).get();
        assertThat(fetchedOrder.getAddress()).isEqualTo(order.getAddress());
    }

    @Test
    void 주문을_삭제한다() {
        // When
        orderRepository.deleteById(order.getId());

        // Then
        Optional<Order> fetchedOrder = orderRepository.findById(order.getId());
        assertThat(fetchedOrder).isEmpty();
    }
}