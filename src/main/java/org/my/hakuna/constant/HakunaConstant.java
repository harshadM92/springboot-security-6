package org.my.hakuna.constant;

import org.springframework.stereotype.Component;

@Component
public class HakunaConstant {

	private final long JWT_EXPIRATION = 70000;
	private final String JWT_SECRET_KEY = ""; //secret key here

	public long getJwtExpiration() {
		return JWT_EXPIRATION;
	}

	public String getJwtSecretKey() {
		return JWT_SECRET_KEY;
	}

}