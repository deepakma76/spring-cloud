package com.payment.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.project.model.Payment;
import com.payment.project.service.PaymentService;

@RestController
@RequestMapping("payments")
public class PaymentController {

	@Value("${server.port}")
	String port;

	@Autowired
	PaymentService paymentService;

	@GetMapping
	public ResponseEntity<List<Payment>> findAllPayment() {
		List<Payment> findAllPayment = paymentService.findAllPayment();
		return ResponseEntity.ok().body(findAllPayment);
	}

	@PostMapping
	public Payment makePayment(@RequestBody Payment payment) {
		return paymentService.makePayment(payment);
	}

}
