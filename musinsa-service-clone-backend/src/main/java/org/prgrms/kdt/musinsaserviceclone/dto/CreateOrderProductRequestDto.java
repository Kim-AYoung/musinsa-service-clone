package org.prgrms.kdt.musinsaserviceclone.dto;

import lombok.Builder;
import lombok.Getter;
import org.prgrms.kdt.musinsaserviceclone.domain.OrderProduct;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;

@Getter
public class CreateOrderProductRequestDto {

    private Long productId;
    private Integer quantity;

    @Builder
    public CreateOrderProductRequestDto(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderProduct toEntity(Product product) {
        return OrderProduct.builder()
                .product(product)
                .quantity(quantity)
                .build();
    }
}
