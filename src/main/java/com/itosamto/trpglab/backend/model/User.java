package com.itosamto.trpglab.backend.model;

import com.itosamto.trpglab.common.config.auth.enums.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String registrationId;

	private String userEmail;

	private String userPw;

	private String userNickName;

	private String userName;

	private String userGender;

	private String picture;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String userBio;

	private Timestamp joinDate;

	protected User() { }

	@Builder
	public User(Integer userId, String registrationId, String userEmail, String userPw, String userNickName, String userName
			, String userGender, String picture, Role role, String userBio, Timestamp joinDate) {
		this.userId = userId;
		this.registrationId = registrationId;
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userNickName = userNickName;
		this.userName = userName;
		this.userGender = userGender;
		this.picture = picture;
		this.role = role;
		this.userBio = userBio;
		this.joinDate = joinDate;
	}

	public User update(String userName, String picture) {
		this.userName = userName;
		this.picture = picture;
		return this;
	}

	public String getRoleKey() {
		return this.role.getKey();
	}


}
