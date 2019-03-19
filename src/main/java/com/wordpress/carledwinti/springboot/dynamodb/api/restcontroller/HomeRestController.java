package com.wordpress.carledwinti.springboot.dynamodb.api.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@GetMapping("/")
	public String home() {
		return "Bem vindo!";
	}
}
