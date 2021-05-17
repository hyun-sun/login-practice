package com.itosamto.loginpractice.config.security.oauth2.user;

import lombok.Getter;

@Getter
public enum Role {
	USER("ROLE_USER", "일반 사용자"),
	BLOCK_USER("ROLE_BLOCK_USER", "차단된 사용자"),
	ADMIN("ROLE_ADMIN", "관리자")
	;

	private final String key;
	private final String title;

	Role(String key, String title) {
		this.key = key;
		this.title = title;
	}
}
