package org.example.ex1.repository;

import org.example.ex1.entity.InventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryLogRepository
        extends JpaRepository<InventoryLog, Long> {
}