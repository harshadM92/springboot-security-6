package org.my.hakuna.dao;

import java.util.Optional;

import org.my.hakuna.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
	
	Optional<UserInfo> findByUserName(String userName);

}
