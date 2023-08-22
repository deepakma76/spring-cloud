package com.order.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.project.model.Order;
import com.order.project.repository.IOrderRepository;

@Service
public class OrderService {

	@Autowired
	IOrderRepository orderRepository;

	public List<Order> getAllOrders() {
		List<Order> orderList = orderRepository.findAll();
		return orderList;
	}

	public Optional<Order> getOrderById(int id) {
		return orderRepository.findById(id);
	}

	public Order saveOrders(Order order) {
		return orderRepository.saveAndFlush(order);
	}

	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
	}

}
