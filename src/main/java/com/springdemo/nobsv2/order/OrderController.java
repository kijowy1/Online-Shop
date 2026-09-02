package com.springdemo.nobsv2.order;


import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.order.services.CreateOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/{orders}")
public class OrderController {
    private final CreateOrderService createOrderService;
    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(Order order){
        return createOrderService.execute(order);
    }
}