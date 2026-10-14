package com.springdemo.nobsv2.order.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCustomerOrderService implements Command<Integer, List<OrderDTO>> {

    private final OrderRepository orderRepository;

    public GetCustomerOrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> execute(Integer input) {
        List<Order> orders = orderRepository.findByCustomerId(input);

        List<OrderDTO> orderDTOS = orders.stream()
                .map(OrderDTO::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOS);
    }
}