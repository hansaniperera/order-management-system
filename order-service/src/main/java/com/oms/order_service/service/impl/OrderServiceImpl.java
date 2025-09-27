package com.oms.order_service.service.impl;

import com.oms.order_service.dto.OrderRequest;
import com.oms.order_service.model.Order;
import com.oms.order_service.model.OrderItem;
import com.oms.order_service.model.enums.OrderStatus;
import com.oms.order_service.repository.OrderRepository;
import com.oms.order_service.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public UUID createOrder(OrderRequest req) {
        UUID orderId = UUID.randomUUID();
        Order order = new Order();
        order.setId(orderId);
        order.setCustomerId(req.getCustomerId());
        order.setTotalAmount(req.getTotalAmount());
        order.setStatus(String.valueOf(OrderStatus.PENDING));
        order.setCreatedAt(OffsetDateTime.now());

        List<OrderItem> items = req.getItems().stream().map(orderItem ->{
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setQuantity(orderItem.getQuantity());
            item.setProductId(orderItem.getProductId());
            item.setUnitPrice(orderItem.getUnitPrice());
            return item;
        }).toList();

        order.setItems(items);

        orderRepository.save(order);

        return orderId;
    }
}
