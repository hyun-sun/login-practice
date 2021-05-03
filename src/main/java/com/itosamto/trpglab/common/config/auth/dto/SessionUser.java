package com.itosamto.trpglab.common.config.auth.dto;

import com.itosamto.trpglab.backend.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
	private Integer userId;
	private String name;
	private String email;
	private String profileUrl;

	public SessionUser(User user) {
		this.userId = user.getUserId();
		this.name = user.getUserName();
		this.email = user.getUserEmail();
		this.profileUrl = user.getProfileUrl();
	}


}
