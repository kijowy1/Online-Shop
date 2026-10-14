package com.springdemo.nobsv2.order.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOrderService implements Command<Integer, OrderDTO> {

    private final OrderRepository orderRepository;

    public GetOrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<OrderDTO> execute(Integer input) {
        Optional<Order> orderOptional = orderRepository.findById(input);
        if(orderOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new OrderDTO(orderOptional.get()));
        }
        throw new ProductNotFoundException();
    }
}