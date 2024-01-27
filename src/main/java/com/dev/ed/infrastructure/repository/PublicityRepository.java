package com.dev.ed.infrastructure.repository;

import com.dev.ed.infrastructure.entity.PublicityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicityRepository extends JpaRepository<PublicityEntity, Long> {
}
