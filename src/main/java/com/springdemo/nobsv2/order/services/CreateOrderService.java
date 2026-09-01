package com.springdemo.nobsv2.order.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import org.springframework.http.ResponseEntity;

public class CreateOrderService implements Command<Order, OrderDTO> {
    @Override
    public ResponseEntity<OrderDTO> execute(Order input) {
        return null;
    }
}