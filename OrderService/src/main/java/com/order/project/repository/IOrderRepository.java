package com.order.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.project.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
