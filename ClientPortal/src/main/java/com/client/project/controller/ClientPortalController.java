package com.client.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientPortalController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/pay/{price}")
	public String pay(@PathVariable Integer price) {
		return restTemplate.postForObject("http://PAYMENT-SERVICE/payment/" + price, price, String.class);
	}
}
