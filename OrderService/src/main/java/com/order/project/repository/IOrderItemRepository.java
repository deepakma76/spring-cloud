package com.order.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.project.model.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer> {

	public Optional<OrderItem> findByName(String name);

	@Query(value = "select * from orderitem_tb where price = (select max(price) from orderitem_tb)", nativeQuery = true)
	public List<OrderItem> findMaxPricedItems();
}
