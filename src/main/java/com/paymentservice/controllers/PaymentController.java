package com.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.paymentservice.model.Payment;

@RequestMapping("api/v1/payments")
public class PaymentController {
	
	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		try {
			return new ResponseEntity<>(payment, HttpStatus.CREATED);	
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to complete the payment.", e);
		}
	}
	
	 @GetMapping("/payments/{paymentId}")
     public String retrivePaymentDetails(@PathVariable String paymentId) {
        return "Payment details "+paymentId;
     }
	 
	 @GetMapping("/payments/order/{orderId}")
     public String retrivePaymentStatus(@PathVariable String orderId) {
        return "Payment status "+orderId;
     }
	 
	 @GetMapping("/payments/order/{orderId}")
     public String retriveUserPayment(@PathVariable String userId) {
        return "Payment for user "+userId;
     }
	 
}
