package com.example.order.component.behaviour;

import com.example.order.component.structure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
	Order_Repository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order getOrder(Integer id) {
		return orderRepository.getById(id);
	}

	public Customer getCustomer(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:9191/customers/" + id, Customer.class);
		return .getCustomer(id);
	}

	public Order processOrder(int customerId) {

		Customer customer = getCustomer(customerId);
		Cart cart = customer.getCart();

		Order order = new Order();
		order.setOrderId(1);

		int i = 1;

		Set<OrderPosition> orderPositions = new HashSet<OrderPosition>();

		for (CartItem cartItem : cart.getCartItems()) {
			OrderPosition orderPosition = new OrderPosition();
			orderPosition.setPositionId(i++);
			orderPosition.setArticle(cartItem.getArticle());
			orderPosition.setArticleQuantity(cartItem.getQuantity());
			orderPositions.add(orderPosition);
			order.setOrderPositions(orderPositions);
		}

		customer.addOrder(order);

		return order;
	}


	
	public Article get_article(int articleId) {
		Article article = restTemplate.getForObject("http://article-service/article/" + articleId, Article.class);
		return article;
	}

	public Object findAll() {
		return orderRepository.findAll();
	}

//	public OrderPositionEntity get_entity_from_class(OrderPosition orderPosition) {
//		return new OrderPositionEntity(orderPosition.getOrderpos_Id(), orderPosition.getArticle().getId(), orderPosition.getArticleQuantity());
//	}
//
//	public OrderPositionEntity get_class_from_entity(OrderPositionEntity orderPositionEntity) {
//		return new OrderPositionEntity(orderPositionEntity.getOrderpos_id(), orderPositionEntity.getArticleId(), orderPositionEntity.getArticleQuantity());
//	}
	



	//Article article = restTemplate.getForObject("http://article-service/article/", null, null);






}
