package com.example.demo.behaviour;

import com.example.demo.structure.CartItemEntity;
import com.example.demo.structure.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItemEntity,Integer> {

    void deleteCartItemEntitiesByCartId (Integer cartId);

}
