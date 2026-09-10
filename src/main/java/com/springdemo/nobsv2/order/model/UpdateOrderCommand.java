package com.springdemo.nobsv2.order.model;

import com.springdemo.nobsv2.product.model.UpdateProductCommand;
import lombok.Getter;

@Getter
public class UpdateOrderCommand {
    Integer id;
    Order order;
    public UpdateOrderCommand(Integer id, Order order) {
        this.id = id;
        this.order = order;
    }
}