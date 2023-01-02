package com.javatechie.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
