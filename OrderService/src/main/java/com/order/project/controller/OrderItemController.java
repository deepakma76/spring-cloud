package com.order.project.controller;

import java.util.List;

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
import com.order.project.model.OrderItem;
import com.order.project.service.OrderItemService;

@RestController()
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@GetMapping("allOrderItem")
	public ResponseEntity<List<OrderItem>> getAllOrderItems() {
		List<OrderItem> itemList = orderItemService.getAllOrderItem();
		return ResponseEntity.ok().body(itemList);
	}
	
	@GetMapping("maxPricedItem")
	public ResponseEntity<List<OrderItem>> getMaxPricedItems() {
		List<OrderItem> itemList = orderItemService.getMaxPricedItem();
		return ResponseEntity.ok().body(itemList);
	}

	@GetMapping("{id}")
	public ResponseEntity<OrderItem> getOrderById(@PathVariable Integer id) {
		OrderItem orderItem = orderItemService.getOrderItemById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order item " + id + " not found!"));

		return ResponseEntity.ok().body(orderItem);

	}

	@PostMapping("createOrderItem")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
		OrderItem createdOrderItem = orderItemService.saveOrderItem(orderItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable Integer id) {
		orderItemService.getOrderItemById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order item " + id + " not found!"));
		orderItemService.deleteOrderItem(id);
		return ResponseEntity.status(HttpStatus.OK).body("Order item " + id + " deleted successfully.");

	}

}
