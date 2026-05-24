package org.example.ex1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ex1.dto.StockRequest;
import org.example.ex1.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/stock-in")
    public ResponseEntity<?> stockIn(
            @Valid @RequestBody StockRequest request,
            @RequestHeader("X-User") String username,
            @RequestHeader("X-Role") String role) {

        productService.stockIn(
                request.getSku(),
                request.getQuantity(),
                username,
                role
        );

        return ResponseEntity.ok("Stock in success");
    }
}