package org.prgrms.kdt.musinsaserviceclone.dto;

import lombok.Getter;
import org.prgrms.kdt.musinsaserviceclone.domain.Category;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;

@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private Category category;
    private Integer price;
    private String description;

    public ProductResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
    }
}
