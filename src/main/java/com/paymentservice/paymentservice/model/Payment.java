package com.paymentservice.paymentservice.model;

import lombok.Data;

@Data
public class Payment {
	private String orderId;
	private String paymentId;
	private String userId;
	private double amount;
	private String paymentMethod;
	private String currency;
	private String status;
	
}
