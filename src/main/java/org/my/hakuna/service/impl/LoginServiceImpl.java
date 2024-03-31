package org.my.hakuna.service.impl;

import org.my.hakuna.config.JwtGenerator;
import org.my.hakuna.dto.AuthResponseDTO;
import org.my.hakuna.entity.UserInfo;
import org.my.hakuna.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@Override
	public AuthResponseDTO login(UserInfo userInfo) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userInfo.getUserName(), userInfo.getUserPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new AuthResponseDTO(jwtGenerator.generateToken(authentication));
	}

}
