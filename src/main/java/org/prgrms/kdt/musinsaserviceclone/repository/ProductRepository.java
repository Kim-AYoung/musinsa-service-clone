package org.prgrms.kdt.musinsaserviceclone.repository;

import org.prgrms.kdt.musinsaserviceclone.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
