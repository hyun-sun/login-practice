package com.itosamto.trpglab.common.config.auth.dto;

import com.itosamto.trpglab.backend.model.User;
import com.itosamto.trpglab.common.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

	private Map<String, Object> attributes;
	private String registrationId;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String picture;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes,
	                       String registrationId,
	                       String nameAttributeKey,
	                       String name,
	                       String email,
	                       String picture) {
		this.attributes = attributes;
		this.registrationId = registrationId;
		this.nameAttributeKey= nameAttributeKey;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}

	public static OAuthAttributes of(String registrationId,
	                                 String userNameAttributeName,
	                                 Map<String, Object> attributes) {
		return ofGoogle(registrationId, userNameAttributeName, attributes);
	}

	private static OAuthAttributes ofGoogle(String registrationId, String userNameAttributeName,
	                                        Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.registrationId(registrationId)
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.picture((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}


	public User toEntity() {
		return User.builder()
				.registrationId(registrationId)
				.userName(name)
				.userEmail(email)
				.picture(picture)
				.role(Role.GUEST)
				.build();
	}

}