package com.oms.order_service.controller;

import com.oms.order_service.dto.CreateOrderResponse;
import com.oms.order_service.dto.OrderRequest;
import com.oms.order_service.model.Order;
import com.oms.order_service.model.enums.OrderStatus;
import com.oms.order_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody OrderRequest body) {
        UUID orderId = orderService.createOrder(body);
        CreateOrderResponse resp = new CreateOrderResponse(orderId, String.valueOf(OrderStatus.PENDING));
        return ResponseEntity.created(URI.create("/orders/" + orderId)).body(resp);
    }
}
