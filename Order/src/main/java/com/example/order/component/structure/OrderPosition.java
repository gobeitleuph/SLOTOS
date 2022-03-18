package com.example.order.component.structure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.component.behaviour.OrderService;

import lombok.Data;

@Data
public class OrderPosition {

	@Autowired
	OrderService service;

	private Long orderpos_Id;
	private Article article;
	private int articleQuantity;

	public OrderPosition(Long orderposId, Integer articleId, int articleQuantity) {
		this.orderpos_Id = orderposId;
		this.article = service.get_article(articleId);
		this.articleQuantity = articleQuantity;
	}

}
