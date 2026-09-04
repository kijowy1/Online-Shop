package com.springdemo.nobsv2.order.services;

import com.mysql.cj.log.Log;
import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteOrderService implements Command<Integer,Void> {

    private final OrderRepository orderRepository;

    public DeleteOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(DeleteOrderService.class);
    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Order> order = orderRepository.findById(input);
        if(order.isPresent()) {
            orderRepository.deleteById(input);
            logger.info("Deleting Order by id: " + input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ProductNotFoundException();
    }
}