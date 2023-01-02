package com.javatechie.paymentservice.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.paymentservice.model.Payment;
import com.javatechie.paymentservice.service.PaymentService;
@RestController
@RequestMapping("/payment")
public class PaymentController {
@Autowired
private PaymentService paymentService;
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}

}
