package com.dev.ed.infrastructure.repository;

import com.dev.ed.infrastructure.entity.CapturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapturesRepository extends JpaRepository<CapturesEntity, Long> {
}
