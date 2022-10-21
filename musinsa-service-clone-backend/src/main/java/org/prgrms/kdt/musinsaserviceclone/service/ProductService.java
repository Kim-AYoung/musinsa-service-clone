package org.prgrms.kdt.musinsaserviceclone.service;

import lombok.RequiredArgsConstructor;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;
import org.prgrms.kdt.musinsaserviceclone.dto.CreateProductRequestDto;
import org.prgrms.kdt.musinsaserviceclone.dto.ProductResponseDto;
import org.prgrms.kdt.musinsaserviceclone.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponseDto getOne(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 카페가 존재하지않습니다. id=" + id));
        return new ProductResponseDto(product);
    }

    @Transactional(readOnly = true)
    public Product getOneEntity(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 카페가 존재하지않습니다. id=" + id));
    }

    @Transactional
    public Long save(CreateProductRequestDto createProductRequestDto) {
        return productRepository.save(createProductRequestDto.toEntity()).getId();
    }
}
