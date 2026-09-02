package com.springdemo.nobsv2.order.services;

import com.mysql.cj.log.Log;
import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.services.UpdateProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService implements Command<Order, OrderDTO> {
    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    private OrderRepository orderRepository;

    private static final Logger logger = LoggerFactory.getLogger(CreateOrderService.class);

    @Override
    public ResponseEntity<OrderDTO> execute(Order order) {
            Order savedOrder = orderRepository.save(order);
            logger.info("Creating order with id " + savedOrder.getId());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new OrderDTO(savedOrder));

    }
}