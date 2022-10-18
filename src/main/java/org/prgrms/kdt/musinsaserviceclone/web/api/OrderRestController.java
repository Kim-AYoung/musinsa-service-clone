package org.prgrms.kdt.musinsaserviceclone.web.api;

import lombok.RequiredArgsConstructor;
import org.prgrms.kdt.musinsaserviceclone.dto.CreateOrderRequestDto;
import org.prgrms.kdt.musinsaserviceclone.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/v1/order")
    public ResponseEntity<Long> save(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        return ResponseEntity.ok(orderService.save(createOrderRequestDto));
    }
}
