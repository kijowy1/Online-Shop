package com.springdemo.nobsv2.order;


import com.springdemo.nobsv2.order.model.Order;
import com.springdemo.nobsv2.order.model.OrderDTO;
import com.springdemo.nobsv2.order.model.UpdateOrderCommand;
import com.springdemo.nobsv2.order.services.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final CreateOrderService createOrderService;

    private final GetOrderService getOrderService;

    private final GetCustomerOrderService getCustomerOrderService;

    private final GetAllOrderService getAllOrderService;

    private final UpdateOrderService updateOrderService;

    public OrderController(CreateOrderService createOrderService,
                           GetOrderService getOrderService,
                           GetCustomerOrderService getCustomerOrderService,
                           GetAllOrderService getAllOrderService,
                           UpdateOrderService updateOrderService) {
        this.createOrderService = createOrderService;
        this.getOrderService = getOrderService;
        this.getCustomerOrderService = getCustomerOrderService;
        this.getAllOrderService = getAllOrderService;
        this.updateOrderService = updateOrderService;
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
    @GetMapping
    public ResponseEntity<Page<OrderDTO>> getAllOrders(Pageable page){
        return getAllOrderService.execute(page);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Integer id, @RequestBody Order order){
        return updateOrderService.execute(new UpdateOrderCommand(id,order));
    }
}