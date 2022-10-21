package org.prgrms.kdt.musinsaserviceclone.dto;

import lombok.Builder;
import lombok.Getter;
import org.prgrms.kdt.musinsaserviceclone.domain.Order;
import org.prgrms.kdt.musinsaserviceclone.domain.OrderProduct;
import org.prgrms.kdt.musinsaserviceclone.domain.OrderStatus;

import java.util.List;

@Getter
public class CreateOrderRequestDto {

    private String address;
    private List<CreateOrderProductRequestDto> createOrderProductRequestDtos;

    @Builder
    public CreateOrderRequestDto(String address, List<CreateOrderProductRequestDto> createOrderProductRequestDtos) {
        this.address = address;
        this.createOrderProductRequestDtos = createOrderProductRequestDtos;
    }

    public Order toEntity(List<OrderProduct> orderProducts) {
        Order order = Order.builder()
                .address(address)
                .orderStatus(OrderStatus.ACCEPTED)
                .build();
        for(OrderProduct orderProduct : orderProducts) {
            order.addOrderProduct(orderProduct);
        }
        return order;
    }
}
