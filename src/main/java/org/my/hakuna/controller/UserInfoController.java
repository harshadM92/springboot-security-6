package org.my.hakuna.controller;

import java.util.List;

import org.my.hakuna.entity.UserInfo;
import org.my.hakuna.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userManagement")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoServices;

	@GetMapping("/getUserByUserId/{userId}")
	public UserInfo getUserByUserId(@PathVariable Integer userId) {
		return userInfoServices.getUserByUserId(userId);
	}

	@GetMapping("/getAllUser")
	public List<UserInfo> getAllUser() {
		return userInfoServices.getAllUser();
	}

	@PostMapping("/saveUser")
	public Boolean saveUser(@RequestBody UserInfo userInfoRequest) {
		return userInfoServices.saveUser(userInfoRequest);
	}

	@PostMapping("/saveAllUser")
	public Boolean saveAllUser(@RequestBody List<UserInfo> userInfoList) {
		return userInfoServices.saveAllUser(userInfoList);
	}

	@DeleteMapping("/deleteByUserId/{userId}")
	public Boolean deleteByUserId(@PathVariable Integer userId) throws Exception {
		return userInfoServices.deleteByUserId(userId);
	}

}
