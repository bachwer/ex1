package org.example.ex1.dto;


import lombok.Data;

@Data
public class StockRequest {

    @NotBlank(message = "Product ID is required")
    private String sku;



    @Positive
    private Integer quantity;


}
