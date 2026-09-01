package com.springdemo.nobsv2.order;

import com.springdemo.nobsv2.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<LocalDateTime> findByCreatedAtAfter(LocalDateTime createdAtAfter);
}