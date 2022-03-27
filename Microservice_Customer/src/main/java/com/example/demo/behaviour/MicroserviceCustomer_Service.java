package com.example.demo.behaviour;

import com.example.demo.structure.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class MicroserviceCustomer_Service {

	final RestTemplate restTemplate;

	final Customer_Repository customerRepository;

	public MicroserviceCustomer_Service(RestTemplate restTemplate, Customer_Repository customer_repository) {
		this.restTemplate = restTemplate;
		this.customerRepository = customer_repository;
	}

	public CartItemDto createCartItemDto(CartItemEntity cartItem) {
		return new CartItemDto(cartItem.getCartItemId(), cartItem.getArticleId(), cartItem.getQuantity());
	}

	public Set<CartItemDto> createSetCartItemDto(Set<CartItemEntity> cartItemEntitySet) {
		Set<CartItemDto> cartItemSet = new HashSet<CartItemDto>();
		for (CartItemEntity cartItem : cartItemEntitySet) {
			cartItemSet.add(createCartItemDto(cartItem));
		}
		return cartItemSet;
	}

	public Set<CartItemDto> getCartFromCustomerDto(Integer customerId) {
		CustomerEntity customer = customerRepository.getById(customerId);
		return (createSetCartItemDto(customer.getCart().getItems()));
	}

	public String deleteCart(Integer customerId) {
		CustomerEntity customer = getCustomer(customerId);
		customer.getCart().setItems(new HashSet<CartItemEntity>());
		saveCustomer(customer);
		return "cart deleted";
	}

	public void saveCustomer(String name, String address) {
		CustomerEntity customer = new CustomerEntity(name, address);
		customerRepository.save(customer);
	}

	public void saveCustomer(CustomerEntity customer) {
		customerRepository.save(customer);
	}

	public CustomerEntity getCustomer(Integer customerId) {
		return customerRepository.getById(customerId);
	}

	public void addArticleToCart(Integer customerId, Integer articleId) {
		CustomerEntity customer = customerRepository.getById(customerId);

		CartItemEntity cartItem = new CartItemEntity(customer.getId(), customer.getCart(), articleId);

		customer.getCart().getItems().add(cartItem);

		saveCustomer(customer);

	}

	public void decrementArticleQuantity(Integer customerId, Integer articleId) {
		CustomerEntity customer = customerRepository.getById(customerId);
		for (CartItemEntity cartItem : customer.getCart().getItems()) {
			if (cartItem.getArticleId() == articleId)
				if (cartItem.getQuantity() > 0)
					cartItem.setQuantity(cartItem.getQuantity() - 1);
		}
		saveCustomer(customer);
	}

	public void deleteArticleFromCart(Integer customerId, Integer articleId) {
		CustomerEntity customer = customerRepository.getById(customerId);
		Set<CartItemEntity> cartItemEntitySet = customer.getCart().getItems();
		for (CartItemEntity cartItem : customer.getCart().getItems()) {
			if (cartItem.getArticleId() == articleId)
				cartItemEntitySet.remove(cartItem);

			saveCustomer(customer);
		}
	}
}


