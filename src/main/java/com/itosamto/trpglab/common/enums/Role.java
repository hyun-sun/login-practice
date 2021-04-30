package com.itosamto.trpglab.common.enums;

import lombok.Getter;

@Getter
public enum Role {
	USER("USER", "일반 사용자")
	;

	private final String key;
	private final String title;

	Role(String key, String title) {
		this.key = key;
		this.title = title;
	}
}
