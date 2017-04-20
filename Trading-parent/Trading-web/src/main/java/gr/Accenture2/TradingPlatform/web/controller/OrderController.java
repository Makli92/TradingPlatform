package gr.Accenture2.TradingPlatform.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.repository.entity.Order;
import gr.Accenture2.TradingPlatform.repository.service.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{orderId}")
	public Order findOrder(@PathVariable Long orderId) {
		return orderRepository.findById(orderId);
	}
	
	@PostMapping("")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Order createOrder(@Valid @RequestBody Order order) {
	    orderRepository.save(order);
		return order;
	}
}
