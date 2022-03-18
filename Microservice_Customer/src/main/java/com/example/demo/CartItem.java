package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;

@Data
public class CartItem {

	@Autowired
	MicroserviceCustomer_Service service;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemId; // bestellnummer oder eigene ID für jedes bestellte Produkt?
	private int articleId;
	private int quantity;

	public Article get_article() {
		return service.get_article(articleId);
	}

//	@Autowired 
//	CartItem service;

//	@GetMapping("/{article_id}")
//	public ResponseEntity<CartItem> get_Article(@PathVariable("article_id") int article_id) {
//
//		/*
//		 * RestTemplate restTemplate = new RestTemplate(); Article article =
//		 * restTemplate.getForObject("http://article-service/article/" + article_id,
//		 * Article.class);
//		 */
//
//		return ResponseEntity.ok(CartItem.get_article(article_id));
//	}
//
//	public static CartItem get_article(Integer id) {
//		return item_repository.getById(id);
//	}

}
