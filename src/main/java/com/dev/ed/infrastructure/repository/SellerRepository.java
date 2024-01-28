package com.dev.ed.infrastructure.repository;

import com.dev.ed.infrastructure.entity.SellersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellersEntity, Long> {
}
