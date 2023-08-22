package com.order.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.project.model.OrderItem;
import com.order.project.repository.IOrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	IOrderItemRepository orderItemRepository;

	public List<OrderItem> getAllOrderItem() {
		return orderItemRepository.findAll();
	}

	public List<OrderItem> getMaxPricedItem() {
		return orderItemRepository.findMaxPricedItems();
	}

	public Optional<OrderItem> getOrderItemById(int id) {
		return orderItemRepository.findById(id);
	}

	public Optional<OrderItem> getOrderItemByName(String name) {
		return orderItemRepository.findByName(name);
	}

	public OrderItem saveOrderItem(OrderItem orderitem) {
		return orderItemRepository.saveAndFlush(orderitem);
	}

	public List<OrderItem> saveAllOrderItem(List<OrderItem> itemList) {
		return orderItemRepository.saveAllAndFlush(itemList);
	}

	public void deleteOrderItem(int id) {
		orderItemRepository.deleteById(id);
	}

}
