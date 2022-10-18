package org.prgrms.kdt.musinsaserviceclone.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "order_products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderProduct {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_product_id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull
    private Integer quantity;

    @Builder
    public OrderProduct(Product product, Order order, Integer quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        if (Objects.nonNull(this.order)) {
            this.order.getOrderProducts().remove(this);
        }

        this.order = order;
        order.getOrderProducts().add(this);
    }
}
