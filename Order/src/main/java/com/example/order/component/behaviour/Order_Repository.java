package com.example.order.component.behaviour;

import java.util.List;

import com.example.order.component.structure.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Order_Repository extends JpaRepository<Order, Integer> {

}
