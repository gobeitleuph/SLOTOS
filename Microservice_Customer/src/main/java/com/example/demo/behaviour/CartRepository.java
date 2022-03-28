package com.example.demo.behaviour;

import com.example.demo.structure.CartEntity;
import com.example.demo.structure.CartItemEntity;
import com.example.demo.structure.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Integer> {

}
