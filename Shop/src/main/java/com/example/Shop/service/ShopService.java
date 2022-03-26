package com.example.Shop.service;

import com.example.Shop.VO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopService {
@Autowired
private RestTemplate restTemplate;

    @Autowired
    public String getShop() {
        return this.getClass().getSimpleName();
    }

    //TODO: Verschieben in CustomerRestConnectorRequester && an API Gateway anpassen
    public int createCustomerWithCart(int id) {
        restTemplate.postForObject("http://localhost:8081/customer/create", id, String.class);
        return id;
    }

    public Order checkOutCart(int customer_id){
        return restTemplate.getForObject("http://localhost:8080/order/checkOutCart/" + customer_id, Order.class);
    }

    public void getArticle(Long id) {
        restTemplate.getForObject("http://localhost:8080/article/getArticle/" + id, String.class);
    }

    public void getAllArticles() {
        restTemplate.getForObject("http://localhost:8080/article/getAllArticles", String.class);
    }

    public void getCustomer(Long id) {
        restTemplate.getForObject("http://localhost:8080/customer/getCustomer/" + id, String.class);
    }



}

//    Cart cart = new Cart();
//
//    Customer customer = new Customer(cart);
//
//        customers.put(customer.getCustomerId(), customer);
//
//        return customer.getCustomerId();


