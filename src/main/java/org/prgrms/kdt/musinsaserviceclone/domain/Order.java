package org.prgrms.kdt.musinsaserviceclone.domain;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Setter
    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    public Order(String address, OrderStatus orderStatus) {
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProduct.setOrder(this);
    }
}
