package org.prgrms.kdt.musinsaserviceclone.repository;

import org.prgrms.kdt.musinsaserviceclone.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
