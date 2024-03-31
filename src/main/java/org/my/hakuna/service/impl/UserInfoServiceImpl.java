package org.my.hakuna.service.impl;

import java.util.List;
import java.util.Optional;

import org.my.hakuna.dao.UserInfoDao;
import org.my.hakuna.entity.UserInfo;
import org.my.hakuna.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public Boolean saveUser(UserInfo userInfoRequest) {
		userInfoDao.save(userInfoRequest);
		return true;
	}

	@Override
	public List<UserInfo> getAllUser() {
		return userInfoDao.findAll();
	}

	@Override
	public UserInfo getUserByUserId(Integer userId) {
		Optional<UserInfo> optionalUserInfo = userInfoDao.findById(userId);
		return optionalUserInfo.orElse(null);
	}

	@Override
	public Boolean saveAllUser(List<UserInfo> userInfoList) {
		userInfoDao.saveAll(userInfoList);
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteByUserId(Integer userId) throws Exception {
		userInfoDao.deleteById(userId);
		if(userId != null) {
			throw new Exception("userId is null");
		}
		return true;
	}

}
