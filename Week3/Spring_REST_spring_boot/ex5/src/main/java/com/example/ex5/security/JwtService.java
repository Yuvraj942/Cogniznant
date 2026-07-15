package com.example.ex5.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private final String secret;
	private final long expirationMillis;

	public JwtService(
		@Value("${app.jwt.secret:ThisIsAVeryLongDemoSecretKeyForJwtAuth1234567890}") String secret,
		@Value("${app.jwt.expiration-ms:3600000}") long expirationMillis
	) {
		this.secret = secret;
		this.expirationMillis = expirationMillis;
	}

	public String generateToken(String username) {
		Date issuedAt = new Date();
		Date expiration = new Date(issuedAt.getTime() + expirationMillis);

		return Jwts.builder()
			.subject(username)
			.issuedAt(issuedAt)
			.expiration(expiration)
			.signWith(getSigningKey(), SignatureAlgorithm.HS256)
			.compact();
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public boolean isTokenValid(String token, String username) {
		return username.equals(extractUsername(token)) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser()
			.verifyWith((javax.crypto.SecretKey) getSigningKey())
			.build()
			.parseSignedClaims(token)
			.getPayload();
	}

	private Key getSigningKey() {
		byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
		return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
	}
}
