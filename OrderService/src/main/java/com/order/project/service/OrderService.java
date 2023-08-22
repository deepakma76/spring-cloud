package com.order.project.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.project.model.Order;
import com.order.project.model.Payment;
import com.order.project.model.TransactionResponse;
import com.order.project.repository.IOrderRepository;

@Service
public class OrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	RestTemplate restTemplate;

	Random random = new Random();

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(int id) {
		return orderRepository.findById(id);
	}

	public TransactionResponse saveOrders(Order order) {

		Order createdOrder = orderRepository.saveAndFlush(order);
		Payment payment = new Payment();

		payment.setOrderid(createdOrder.getId());
		payment.setStatus(random.nextBoolean() ? "success" : "fail");
		payment.setTransactionAmount(createdOrder.getTotalprice());
		Payment response = restTemplate.postForObject("http://PAYMENT-SERVICE/payments", payment, Payment.class);
		if (response != null) {
			return new TransactionResponse(order, response.getStatus(), response.getTransactionid());
		}
		return null;
	}

	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
	}

}
