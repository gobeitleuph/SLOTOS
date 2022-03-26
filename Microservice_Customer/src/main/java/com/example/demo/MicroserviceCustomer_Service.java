package com.example.demo;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceCustomer_Service {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Customer_Repository customer_repository;

	public void save_customer(int id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer_repository.save(customer);
	}

	//TODO: muss nicht
//	public String get_customer_name(Integer id) {
//		return customer_repository.getById(id).getLastName();
//
//	}
//	public String get_customer_name (Integer id) {	
//		String customer_name;
//		customer_name = customer_repository.getById(id).getLastName()+", "+customer_repository.getById(id).getFirstName();		
//		return customer_name;
//		}

	public static Table getCustomers() {
		return null;
	}

	public Article get_article(int articleId) {
		Article article = restTemplate.getForObject("http://article-service/article/" + articleId, Article.class);
		return article;
	}
}

//	public Customer createCustomer(Customer customer) {
//		customer.setId(null);
//		customer.add(customer);
//	}
