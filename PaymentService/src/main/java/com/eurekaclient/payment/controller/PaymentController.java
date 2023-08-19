package com.eurekaclient.payment.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@PostMapping("/payment/{price}")
	public String payment(@PathVariable Integer price) {
		return price + " received successfully";
	}
}
