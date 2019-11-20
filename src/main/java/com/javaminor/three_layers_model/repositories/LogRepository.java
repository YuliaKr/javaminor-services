package com.javaminor.three_layers_model.repositories;

import com.javaminor.three_layers_model.repositories.entities.PerformanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<PerformanceLog, Long> {
}
