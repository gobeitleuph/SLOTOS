package com.example.order.component.behaviour;

import com.example.order.component.structure.*;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

	private RestTemplate restTemplate;
	private Order_Repository orderRepository;

	@Autowired
	private EurekaClient eurekaClient;

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

		InstanceInfo service = eurekaClient
				.getApplication("customer-service")
				.getInstances()
				.get(0);

		String hostName = service.getHostName();
		int port = service.getPort();

		String customerServiceURL = "http://" + hostName + ":" + port;
		CartItemDto[] itemArray =  restTemplate.getForObject(customerServiceURL + "/customers/sendCart?customerId=" + customerId, CartItemDto[].class);
		Set<CartItemDto> itemSet = Arrays.stream(itemArray).collect(Collectors.toSet());
		processOrder(itemSet);

		return restTemplate.getForObject(customerServiceURL + "/customers/deleteCart?customerId=" + customerId, String.class);
	}

}


