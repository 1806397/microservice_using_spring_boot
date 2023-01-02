package com.javatechie.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javatechie.orderservice.common.Payment;
import com.javatechie.orderservice.common.TransactionRequest;
import com.javatechie.orderservice.common.TransactionResponse;
import com.javatechie.orderservice.model.Order;
import com.javatechie.orderservice.repository.OrderRepository;

@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;
@Autowired
private RestTemplate restTemplate;
public TransactionResponse saveOrder(TransactionRequest request) {
	String response="";
	Order order=request.getOrder();
	Payment payment=request.getPayment();
	payment.setOrderId(order.getId());
	payment.setAmount(order.getPrice());
	Payment paymentResponse=restTemplate.postForObject("http://localhost:8050/payment/doPayment", payment, Payment.class);
	response=paymentResponse.getPaymentStatus().equals("success")?"payment processing successful":"there is a failure in payment";

	orderRepository.save(order);
	return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
}


}
