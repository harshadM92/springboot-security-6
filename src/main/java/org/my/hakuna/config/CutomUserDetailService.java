package org.my.hakuna.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.my.hakuna.dao.UserInfoDao;
import org.my.hakuna.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CutomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDao.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("User name not found"));
		return new User(userInfo.getUserName(),userInfo.getUserPassword(),mapRolesToGrantedAuthority(Arrays.asList("ADMIN","USER")));
	}

	private Collection<GrantedAuthority> mapRolesToGrantedAuthority(List<String> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}
}
