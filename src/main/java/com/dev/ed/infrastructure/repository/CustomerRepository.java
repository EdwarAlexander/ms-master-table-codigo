package com.dev.ed.infrastructure.repository;

import com.dev.ed.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query("SELECT customer FROM CustomerEntity customer WHERE customer.document = :document ")
    Optional<CustomerEntity> findByDocumento(@Param("document") String document);
}
