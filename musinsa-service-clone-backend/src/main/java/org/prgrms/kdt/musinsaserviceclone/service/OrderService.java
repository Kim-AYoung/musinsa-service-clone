package org.prgrms.kdt.musinsaserviceclone.service;

import lombok.RequiredArgsConstructor;
import org.prgrms.kdt.musinsaserviceclone.domain.OrderProduct;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;
import org.prgrms.kdt.musinsaserviceclone.dto.CreateOrderRequestDto;
import org.prgrms.kdt.musinsaserviceclone.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Transactional
    public Long save(CreateOrderRequestDto createOrderRequestDto) {
        List<OrderProduct> orderProducts = createOrderRequestDto.getCreateOrderProductRequestDtos().stream().map((v) -> {
            Product one = productService.getOneEntity(v.getProductId());
            return v.toEntity(one);
        }).toList();
        return orderRepository.save(createOrderRequestDto.toEntity(orderProducts)).getId();
    }
}
