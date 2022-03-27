package com.example.demo.behaviour;

import com.example.demo.structure.Article;
import com.example.demo.structure.CartItemEntity;
import com.example.demo.structure.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceCustomer_Service {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Customer_Repository customer_repository;


//	public String get_customer_name (Integer id) {	
//		String customer_name;
//		customer_name = customer_repository.getById(id).getLastName()+", "+customer_repository.getById(id).getFirstName();		
//		return customer_name;
//		}

/*	public static Table getCustomers() {
		return null;
	}

	public Article get_article(int articleId) {
		Article article = restTemplate.getForObject("http://article-service/article/" + articleId, Article.class);
		return article;
	}*/

	public void saveCustomer(String name, String address) {
		CustomerEntity customer = new CustomerEntity(name, address);
		customer_repository.save(customer);
	}
	public void saveCustomer(CustomerEntity customer) {
		customer_repository.save(customer);
	}

	public void addArticleToCart(Integer customerId, Integer articleId) {
		CustomerEntity customer = customer_repository.getById(customerId);

		CartItemEntity cartItem = new CartItemEntity(customer.getId(), customer.getCart(), articleId);

		customer.getCart().getItems().add(cartItem);

		saveCustomer(customer);

	}
}


