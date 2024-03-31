package org.my.hakuna.service;

import org.my.hakuna.dto.AuthResponseDTO;
import org.my.hakuna.entity.UserInfo;

public interface LoginService {

	public AuthResponseDTO login(UserInfo userInfo);
}
