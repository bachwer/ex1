package org.example.ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.ex1.dto.InventoryResponse;
import org.example.ex1.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void stockIn(String sku,
                        Integer quantity,
                        String username,
                        String role) {

        productRepository.stockIn(sku, quantity);
    }

    @Override
    public void stockOut(String sku,
                         Integer quantity,
                         String username,
                         String role) {

        int updated = productRepository.stockOut(sku, quantity);

        if (updated == 0) {
            throw new RuntimeException("Not enough stock");
        }
    }

    @Override
    public void deleteProduct(Long id,
                              String username,
                              String role) {

        productRepository.deleteById(id);
    }

    @Override
    public InventoryResponse inspectInventory() {

        return new InventoryResponse();
    }
}