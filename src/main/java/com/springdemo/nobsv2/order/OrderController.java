package com.springdemo.nobsv2.order;


import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.order.services.CreateOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final CreateOrderService createOrderService;
    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order){
        return createOrderService.execute(order);
    }
}