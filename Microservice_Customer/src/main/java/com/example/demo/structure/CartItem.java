package com.example.demo.structure;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.example.demo.behaviour.MicroserviceCustomer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

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

	/*public Article get_article() {
		return service.get_article(articleId);
	}*/

}
