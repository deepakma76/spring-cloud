package com.payment.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.project.model.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
