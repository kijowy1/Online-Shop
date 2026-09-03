package com.springdemo.nobsv2.order;


import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.order.services.CreateOrderService;
import com.springdemo.nobsv2.order.services.GetCustomerOrderService;
import com.springdemo.nobsv2.order.services.GetOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final CreateOrderService createOrderService;

    private final GetOrderService getOrderService;

    private final GetCustomerOrderService getCustomerOrderService;
    public OrderController(CreateOrderService createOrderService,
                           GetOrderService getOrderService,
                           GetCustomerOrderService getCustomerOrderService) {
        this.createOrderService = createOrderService;
        this.getOrderService = getOrderService;
        this.getCustomerOrderService = getCustomerOrderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order){
        return createOrderService.execute(order);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Integer id){
        return getOrderService.execute(id);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderDTO>> getCustomerOrders(@PathVariable Integer id){
        return getCustomerOrderService.execute(id);
    }
}