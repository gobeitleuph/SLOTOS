package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Table;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin
public class MicroserviceCustumer_Controller {
	
@Autowired
MicroserviceCustomer_Service service;
	


	@GetMapping("/get_customers")
	public ResponseEntity<Table> getCustomers() {
		Table customers = MicroserviceCustomer_Service.getCustomers();
		return ResponseEntity.ok(customers);
	}
	
	
	@GetMapping("/get_customer_name")
	public ResponseEntity<String> get_Customer_name(@RequestParam(value="id", defaultValue = "0", required = true) int customer_id) {
		
		return ResponseEntity.ok(service.get_customer_name(customer_id));
		
	}
	
	
	
	
	
	@PostMapping("/get_customer_name")
	public ResponseEntity<String> get_customer_name_post(@RequestBody Customer customer) {
		return ResponseEntity.ok(customer.getLastName());
		
	}
	
	@PostMapping("/save_customer")
	public ResponseEntity<String> save_customer(@RequestBody Customer customer) {
		service.save_customer(customer);
		
		return ResponseEntity.ok("Alles wurde gespeichert");
	}


}
