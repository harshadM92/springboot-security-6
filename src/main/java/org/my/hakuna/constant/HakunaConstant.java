package org.my.hakuna.constant;

import org.springframework.stereotype.Component;

@Component
public class HakunaConstant {

	private final long JWT_EXPIRATION = 70000;
	private final String JWT_SECRET_KEY = "9FYYC75mxRjq81bRpI39O-Ow8RWOqzUMZkCdl2QtlXPiwTgY";

	public long getJwtExpiration() {
		return JWT_EXPIRATION;
	}

	public String getJwtSecretKey() {
		return JWT_SECRET_KEY;
	}

}