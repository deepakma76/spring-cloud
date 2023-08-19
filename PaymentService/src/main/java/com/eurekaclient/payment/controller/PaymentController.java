package com.eurekaclient.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Value("${server.port}")
	String port;

	@PostMapping("/payment/{price}")
	public String payment(@PathVariable Integer price) {
		return price + " received successfully, server running on port " + port;
	}
}
