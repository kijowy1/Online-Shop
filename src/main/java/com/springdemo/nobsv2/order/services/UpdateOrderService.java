package com.springdemo.nobsv2.order.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.order.model.UpdateOrderCommand;
import com.springdemo.nobsv2.product.model.UpdateProductCommand;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateOrderService implements Command<UpdateOrderCommand, OrderDTO> {
    private final OrderRepository orderRepository;

    public UpdateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<OrderDTO> execute(UpdateOrderCommand command) {
        Optional<Order> orderDTOOptional = orderRepository.findById(command.getId());
        if(orderDTOOptional.isPresent()){
            Order newOrder = command.getOrder();
            newOrder.setId(command.getId());
            //TODO:
            // Order Validator
            orderRepository.save(newOrder);
            return ResponseEntity.ok(new OrderDTO(newOrder));
        }
        throw new ProductNotFoundException();


    }
}