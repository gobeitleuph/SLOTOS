package com.example.demo.behaviour;

import com.example.demo.structure.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_Repository extends JpaRepository<CustomerEntity,Integer> {

}
