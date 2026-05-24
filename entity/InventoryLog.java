package org.example.ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_logs")
@Data
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private String username;

    private String action;

    @Column(columnDefinition = "TEXT")
    private String detail;
}