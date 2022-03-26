package com.example.demo.behaviour;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin
public class MicroserviceCustumer_Controller {
	
@Autowired
MicroserviceCustomer_Service service;
	


/*	@GetMapping("/get_customers")
	public ResponseEntity<Table> getCustomers() {
		Table customers = MicroserviceCustomer_Service.getCustomers();
		return ResponseEntity.ok(customers);
	}
	
	
	@GetMapping("/get_customer_name")
	public ResponseEntity<String> get_Customer_name(@RequestParam(value="id", defaultValue = "0", required = true) int customer_id) {
		
		return ResponseEntity.ok(service.get_customer_name(customer_id));
		
	}*/

	@Transactional
	@GetMapping("/save_customer")
	public ResponseEntity<String> save_customer(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address) {
		service.saveCustomer(name, address);
		return ResponseEntity.ok("Alles wurde gespeichert");
	}


}