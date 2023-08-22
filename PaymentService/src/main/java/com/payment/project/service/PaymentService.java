package com.payment.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.project.model.Payment;
import com.payment.project.repository.IPaymentRepository;

@Service
public class PaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	public List<Payment> findAllPayment() {
		return paymentRepository.findAll();
	}
	
	public Payment makePayment(Payment payment)
	{
		return paymentRepository.save(payment);
	}
}
