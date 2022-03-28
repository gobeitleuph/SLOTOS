package com.example.demo.behaviour;

import com.example.demo.structure.CartItemDto;
import com.example.demo.structure.CustomerEntity;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class MicroserviceCustumer_Controller {

	private MicroserviceCustomer_Service service;

	public MicroserviceCustumer_Controller (MicroserviceCustomer_Service service){
		this.service = service;
	}


	@GetMapping(value = "/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable(value = "customer_id")Integer customerId){
		System.out.println(service.getCustomer(customerId).getAddress());
		return ResponseEntity.ok(service.getCustomer(customerId));
	}

	@Transactional
	@GetMapping("/deleteCart")
	public ResponseEntity<String> deleteCart(@RequestParam(value = "customerId") Integer customerId){
		return ResponseEntity.ok(service.deleteCart(customerId));
	}

	@Transactional
	@GetMapping("/save_customer")
	public ResponseEntity<String> save_customer(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address) {
		service.createCustomerWithCart(name, address);
		return ResponseEntity.ok("Alles wurde gespeichert");
	}

	@Transactional
	@GetMapping("/addArticleToCart")
	public ResponseEntity<String> addArticleToCart(@RequestParam(value = "customerId")Integer customerId, @RequestParam(value = "articleId")Integer articleId){
		service.addArticleToCart(customerId, articleId);
		return ResponseEntity.ok("Artikel wurde eingefügt");
	}

	@Transactional
	@GetMapping("/deleteArticleFromCart")
	public ResponseEntity<String> deleteArticleFromCart(@RequestParam(value = "customerId")Integer customerId, @RequestParam(value = "articleId")Integer articleId){
		service.deleteArticleFromCart(customerId, articleId);
		return ResponseEntity.ok("Artikel wurde entfernt");
	}

	@Transactional
	@GetMapping("/decrementArticleQuantity")
	public ResponseEntity<String> decrementArticleQuantity(@RequestParam(value = "customerId")Integer customerId, @RequestParam(value = "articleId")Integer articleId){
		service.decrementArticleQuantity(customerId, articleId);
		return ResponseEntity.ok("Artikel Zahl -1");
	}
	
	@GetMapping("/sendCart")
	public ResponseEntity<Set<CartItemDto>> sendCart (@RequestParam(value = "customerId")Integer customerId){
		return ResponseEntity.ok(service.getCartFromCustomerDto(customerId));
	}



	
}
