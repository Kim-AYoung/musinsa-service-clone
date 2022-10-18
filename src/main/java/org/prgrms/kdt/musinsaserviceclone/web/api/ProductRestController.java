package org.prgrms.kdt.musinsaserviceclone.web.api;

import lombok.RequiredArgsConstructor;
import org.prgrms.kdt.musinsaserviceclone.dto.CreateProductRequestDto;
import org.prgrms.kdt.musinsaserviceclone.dto.ProductResponseDto;
import org.prgrms.kdt.musinsaserviceclone.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/api/v1/product/{id}")
    public ResponseEntity<ProductResponseDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getOne(id));
    }

    @PostMapping("/api/v1/product")
    public ResponseEntity<Long> save(@RequestBody CreateProductRequestDto createProductRequestDto) {
        return ResponseEntity.ok(productService.save(createProductRequestDto));
    }
}
