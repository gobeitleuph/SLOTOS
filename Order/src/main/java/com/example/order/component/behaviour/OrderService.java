package com.example.order.component.behaviour;

import com.example.order.component.structure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderService {

	private RestTemplate restTemplate;
	private Order_Repository orderRepository;

	public OrderService(RestTemplate restTemplate, Order_Repository orderRepository) {
		this.restTemplate = restTemplate;
		this.orderRepository = orderRepository;
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order getOrder(Integer id) {
		return orderRepository.getById(id);
	}


	public Order processOrder(Set<CartItemDto> cartItemSet) {


		Order order = new Order();
		order.setOrderId(UUID.randomUUID().toString());

		int i = 1;

		Set<OrderPosition> orderPositions = new HashSet<OrderPosition>();

		for (CartItemDto cartItem : cartItemSet) {
			OrderPosition orderPosition = new OrderPosition();
			orderPosition.setOrderposId(i++);
			orderPosition.setArticleId(cartItem.getArticleId());
			orderPosition.setQuantity(cartItem.getQuantity());
			orderPositions.add(orderPosition);
			order.setOrderPositions(orderPositions);
			order.setCustomerId(cartItem.getCartItemId());
		}

		saveOrder(order);
		return order;
	}

	@Transactional
	public String checkOutCartForCustomer(Integer customerId){
		Set<CartItemDto> cartItemDtoSet =  restTemplate.getForObject("http://customer-service/customers/" + customerId, Set.class);
		processOrder(cartItemDtoSet);

		String emptyCart = restTemplate.getForObject("http://customer-service/customers/deleteCart/" + customerId, String.class);
		return emptyCart;
	}

}


