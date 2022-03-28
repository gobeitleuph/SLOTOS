package com.example.order.component.behaviour;



import com.example.order.component.structure.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_Repository extends JpaRepository<Order, Integer> {

}
