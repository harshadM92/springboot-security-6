package org.my.hakuna.service;

import java.util.List;

import org.my.hakuna.entity.UserInfo;

public interface UserInfoService {

	public Boolean saveUser(UserInfo userInfoRequest);

	public List<UserInfo> getAllUser();

	public UserInfo getUserByUserId(Integer userId);

	public Boolean saveAllUser(List<UserInfo> userInfoList);

	public Boolean deleteByUserId(Integer userId) throws Exception;
	
}
