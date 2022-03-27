package com.example.order.component.behaviour;

import com.example.order.component.structure.Order;
import com.example.order.component.structure.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") Integer id) {
		return orderService.getOrder(id);
	}

	@GetMapping("checkOutCart")
	public ResponseEntity<String> checkOutCart(@RequestParam(value = "customerId")Integer customerId){
		return ResponseEntity.ok(orderService.checkOutCartForCustomer(customerId));
	}

}
