package org.my.hakuna.dto;

public class AuthResponseDTO {

	private String token;
	private String tokenType= "Bearer";
	
	public AuthResponseDTO(String token) {
		super();
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenType() {
		return tokenType;
	}
}
