package com.example.order.connector;

import com.example.order.component.structure.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "orders", configuration = OrderConfiguration.class)
    public interface OrderClient {
        @RequestMapping(method = RequestMethod.GET, value = "/orders")
        List<Order> getOrders();

        @RequestMapping(method = RequestMethod.POST, value = "/orders/{orderId}", consumes = "application/json")
        Order update(@PathVariable("orderId") Integer orderId, Order order);
    }


