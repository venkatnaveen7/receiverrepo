package com.demo.receiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ReceiveController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
 	private int port;

	@GetMapping("/receive")
	public String receiveText(){
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/api/send", String.class);
		return "Receiver application running on "+port+ " and "+response.getBody();
	}
}
