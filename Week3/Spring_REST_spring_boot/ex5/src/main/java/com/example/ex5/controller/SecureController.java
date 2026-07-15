package com.example.ex5.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureController {

	@GetMapping("/hello")
	public Map<String, String> hello(Authentication authentication) {
		return Map.of(
			"message", "Hello, " + authentication.getName() + ". You accessed a protected endpoint with JWT.",
			"user", authentication.getName()
		);
	}

	@GetMapping("/admin")
	public Map<String, String> admin(Authentication authentication) {
		return Map.of(
			"message", "Admin access granted to " + authentication.getName(),
			"role", "ADMIN"
		);
	}
}
