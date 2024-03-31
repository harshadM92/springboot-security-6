package org.my.hakuna.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.my.hakuna.constant.HakunaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtGenerator {

	@Autowired
	private HakunaConstant hakunaConstant;

	public String generateToken(Authentication authentication) {
		String userName = authentication.getName();
		Date currentDate = new Date();
		Date expiryDate = new Date(currentDate.getTime() + hakunaConstant.getJwtExpiration());
		String token = Jwts.builder().subject(userName).issuedAt(currentDate).expiration(expiryDate)
				.signWith(getSecretKey()).compact();
		return token;
	}

	public String getUserNameFromToken(String token) {
		return getClaimForToken(token).getSubject();
	}

	public boolean validateToken(String token) {
		try {
			getClaimForToken(token);
			return true;
		} catch (Exception e) {
			throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
		}
	}

	private Claims getClaimForToken(String token) {
		return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
	}

	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(hakunaConstant.getJwtSecretKey().getBytes(StandardCharsets.UTF_8));
	}
}
