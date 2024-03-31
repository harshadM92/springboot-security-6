package org.my.hakuna.controller;

import org.my.hakuna.dto.AuthResponseDTO;
import org.my.hakuna.entity.UserInfo;
import org.my.hakuna.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginManagement")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/loginme")
	public AuthResponseDTO login(@RequestBody UserInfo userInfo) {
		return loginService.login(userInfo);
	}
	
}
