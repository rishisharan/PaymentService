package com.paymentservice.paymentservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.paymentservice.paymentservice.model.Payment;


@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		try {
			logger.info("Creating payment "+payment);
			return new ResponseEntity<>(payment, HttpStatus.CREATED);	
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to complete the payment.", e);
		}
	}
	
	 @GetMapping("/{paymentId}")
     public ResponseEntity<String> retrivePaymentDetails(@PathVariable String paymentId) {
	    logger.info("Retrieving payment "+paymentId);
    	return new ResponseEntity<>("Payment details ", HttpStatus.OK);	
     }
	 
	 @GetMapping("/status/{paymentId}")
     public ResponseEntity<String> retrivePaymentStatus(@PathVariable String paymentId) {
		logger.info("Retrieve payment status"+paymentId);
    	return new ResponseEntity<>("Payment status ", HttpStatus.OK);	
     }
	 
	 @GetMapping("/order/{orderId}")
     public ResponseEntity<String> retriveUserPayment(@PathVariable String userId) {
	    logger.info("Retrieve User payment" + userId);
		return new ResponseEntity<>("Payment for user ", HttpStatus.OK);	
     }
 
}
