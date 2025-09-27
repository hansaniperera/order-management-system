package com.oms.order_service.service;

import com.oms.order_service.dto.OrderRequest;

import java.util.UUID;

public interface OrderService {

    UUID createOrder(OrderRequest req);
}
