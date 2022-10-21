package org.prgrms.kdt.musinsaserviceclone.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Table(name = "products")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTime{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Setter
    private String name;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @NotNull
    private Integer price;

    private String description;

    @Builder
    public Product(String name, Category category, Integer price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
}
