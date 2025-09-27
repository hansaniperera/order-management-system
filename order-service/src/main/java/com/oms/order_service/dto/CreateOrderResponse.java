package com.oms.order_service.dto;

import java.util.UUID;

public class CreateOrderResponse {
    private UUID orderId;
    private String status;

    public CreateOrderResponse(UUID orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
