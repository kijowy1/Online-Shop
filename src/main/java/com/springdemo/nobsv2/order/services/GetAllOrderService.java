package com.springdemo.nobsv2.order.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.order.OrderRepository;
import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.product.model.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.util.List;

@Service
public class GetAllOrderService implements Query<Pageable, Page<OrderDTO>> {
    public GetAllOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<Page<OrderDTO>> execute(Pageable input) {
        Page<Order> page = orderRepository.findAll(input);
        Page<OrderDTO> pageOrderDTO = page.map(OrderDTO::new);

        return ResponseEntity.status(HttpStatus.OK).body(pageOrderDTO);

    }
}