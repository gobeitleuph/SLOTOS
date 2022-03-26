package com.example.Shop.controller;

import com.example.Shop.ShopApplication;
import com.example.Shop.VO.Customer;
import com.example.Shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String getShop() {
        return shopService.getShop();
    }

    @PostMapping("/createCustomer")
    public int createCustomerWithCart(@RequestBody int id){
        return shopService.createCustomerWithCart(id);
    }
}




