package com.order.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.project.errorhandling.ResourceNotFoundException;
import com.order.project.model.Order;
import com.order.project.model.OrderItem;
import com.order.project.model.TransactionResponse;
import com.order.project.service.OrderItemService;
import com.order.project.service.OrderService;

@RestController()
@RequestMapping("orders")
public class OrderController {

	private static final String ORDER_CONSTANT = "Order ";

	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemService itemService;

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orderList = orderService.getAllOrders();
		return ResponseEntity.ok().body(orderList);
	}

	@GetMapping("{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
		Order order = orderService.getOrderById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ORDER_CONSTANT + id + " not found!"));

		return ResponseEntity.ok().body(order);
	}

	@PostMapping
	public ResponseEntity<TransactionResponse> createOrder(@RequestBody Order order) {
		Set<OrderItem> items = order.getOrderitem();
		if (!items.isEmpty()) {
			Double totalprice = items.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
			order.setTotalprice(totalprice);
		}
		TransactionResponse createdOrder = orderService.saveOrders(order);
		if (createdOrder == null) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(createdOrder);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
		Optional<Order> foundOrder = orderService.getOrderById(id);
		if (!foundOrder.isPresent()) {
			throw new ResourceNotFoundException(ORDER_CONSTANT + id + " not found!");
		}
		orderService.deleteOrder(foundOrder.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(ORDER_CONSTANT + id + " deleted successfully.");
	}

}
