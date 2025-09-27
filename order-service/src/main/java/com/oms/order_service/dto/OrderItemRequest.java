package com.oms.order_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class OrderItemRequest {

    @NotBlank
    private String productId;

    @Min(1)
    private int quantity;


    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal unitPrice;

    public @NotBlank String getProductId() {
        return productId;
    }

    public void setProductId(@NotBlank String productId) {
        this.productId = productId;
    }

    @Min(1)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(1) int quantity) {
        this.quantity = quantity;
    }

    public @DecimalMin(value = "0.00", inclusive = true) BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(@DecimalMin(value = "0.00", inclusive = true) BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
