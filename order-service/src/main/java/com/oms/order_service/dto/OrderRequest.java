package com.oms.order_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderRequest {

    @NotNull
    private UUID customerId;

    @NotEmpty
    private List<@Valid OrderItemRequest> items;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    private BigDecimal totalAmount;

    public @NotNull UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@NotNull UUID customerId) {
        this.customerId = customerId;
    }

    public @NotEmpty List<@Valid OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(@NotEmpty List<@Valid OrderItemRequest> items) {
        this.items = items;
    }

    public @NotNull @DecimalMin(value = "0.01", inclusive = true) BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(@NotNull @DecimalMin(value = "0.01", inclusive = true) BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
