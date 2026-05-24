package org.example.ex1.service;

import org.example.ex1.dto.InventoryResponse;

public interface ProductService {

    void stockIn(String sku,
                 Integer quantity,
                 String username,
                 String role);

    void stockOut(String sku,
                  Integer quantity,
                  String username,
                  String role);

    void deleteProduct(Long id,
                       String username,
                       String role);

    InventoryResponse inspectInventory();
}