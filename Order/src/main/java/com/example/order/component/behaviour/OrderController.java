package com.example.order.component.behaviour;

import com.example.order.component.structure.Order;
import com.example.order.component.structure.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	 @PostMapping("/")
		public Order saveOrder(@RequestBody Order order) {
			return orderService.saveOrder(order);
		}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") Integer id) {
		return orderService.getOrder(id);
	}
//	 @GetMapping("/{id}")
//		 public ResponseTemplate getOrderWithArticle(@PathVariable("id")int order_id) {
//		 return	orderService.getOrderWithArticle(order_id);
//		}


}
