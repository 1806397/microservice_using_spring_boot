package com.javatechie.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javatechie.orderservice.common.TransactionRequest;
import com.javatechie.orderservice.common.TransactionResponse;

import com.javatechie.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

		return orderService.saveOrder(request);
//		do a rest call to payment and pass the order id
	}

}
