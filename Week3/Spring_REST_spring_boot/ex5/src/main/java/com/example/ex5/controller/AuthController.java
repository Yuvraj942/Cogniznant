package com.example.ex5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex5.dto.AuthResponse;
import com.example.ex5.dto.LoginRequest;
import com.example.ex5.security.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
		);

		String token = jwtService.generateToken(authentication.getName());
		return ResponseEntity.ok(new AuthResponse(token, "Bearer", authentication.getName()));
	}
}
