package org.prgrms.kdt.musinsaserviceclone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.prgrms.kdt.musinsaserviceclone.domain.Category;
import org.prgrms.kdt.musinsaserviceclone.domain.Product;

@NoArgsConstructor
@Getter
public class CreateProductRequestDto {

    private String name;
    private Category category;
    private Integer price;
    private String description;

    @Builder
    public CreateProductRequestDto(String name, Category category, Integer price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .category(category)
                .price(price)
                .description(description)
                .build();
    }
}
