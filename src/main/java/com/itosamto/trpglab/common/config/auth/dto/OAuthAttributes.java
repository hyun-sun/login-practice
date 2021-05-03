package com.itosamto.trpglab.common.config.auth.dto;

import com.itosamto.trpglab.backend.model.User;
import com.itosamto.trpglab.common.config.auth.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class OAuthAttributes {

	private Map<String, Object> attributes;
	private String registrationId;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String profileUrl;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes,
	                       String registrationId,
	                       String nameAttributeKey,
	                       String name,
	                       String email,
	                       String profileUrl) {
		this.attributes = attributes;
		this.registrationId = registrationId;
		this.nameAttributeKey= nameAttributeKey;
		this.name = name;
		this.email = email;
		this.profileUrl = profileUrl;
	}

	public static OAuthAttributes of(String registrationId,
	                                 String userNameAttributeName,
	                                 Map<String, Object> attributes) {
		switch (registrationId) {
			case "google":
				return ofGoogle(registrationId, userNameAttributeName, attributes);
			case "kakao":
				return ofKakao(registrationId, userNameAttributeName, attributes);
		}
		return null;
	}

	private static OAuthAttributes ofGoogle(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.registrationId(registrationId)
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.profileUrl((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}

	private static OAuthAttributes ofKakao(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		String name = (String) ((LinkedHashMap)((LinkedHashMap) attributes.get("kakao_account")).get("profile")).get("nickname");
		String email = (String) ((LinkedHashMap) attributes.get("kakao_account")).get("email");
		String picture = (String) ((LinkedHashMap)((LinkedHashMap) attributes.get("kakao_account")).get("profile")).get("profile_image_url");
		return OAuthAttributes.builder()
				.registrationId(registrationId)
				.name(name)
				.email(email)
				.profileUrl(picture)
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}


	public User toEntity() {
		return User.builder()
				.registrationId(registrationId)
				.userName(name)
				.userEmail(email)
				.profileUrl(profileUrl)
				.role(Role.USER)
				.build();
	}

}
