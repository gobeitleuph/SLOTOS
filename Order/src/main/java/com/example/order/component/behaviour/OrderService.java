package com.example.order.component.behaviour;

import com.example.order.component.structure.Article;
import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;
import com.example.order.component.structure.OrderPositionEntity;
import com.example.order.component.structure.ResponseTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
	Order_Repository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

//	public ResponseTemplate getOrderWithArticle(int orderId) {
//		ResponseTemplate rt = new ResponseTemplate();
//		Order order = orderRepository.findByOrderId(orderId);
//
//		//TODO
//		Article article = restTemplate.getForObject("http://article-service/article/" + order.getArticleId(), Article.class);
//
//		rt.setArticle(article);
//		rt.setOrder(order);
//
//		return rt;
//
//	}
	
	public Article get_article(int articleId) {
		Article article = restTemplate.getForObject("http://article-service/article/" + articleId, Article.class);
		return article;
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
