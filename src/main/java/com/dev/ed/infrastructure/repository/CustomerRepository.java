package com.dev.ed.infrastructure.repository;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
