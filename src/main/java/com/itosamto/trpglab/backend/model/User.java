package com.itosamto.trpglab.backend.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String userEmail;

	private String userPw;

	private String userNickName;

	private String userName;

	private String userGender;

	private String userBio;

	private Timestamp joinDate;

	protected User() { }

	@Builder
	public User(Integer userId, String userEmail, String userPw, String userNickName, String userName
			, String userGender, String userBio, Timestamp joinDate) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userNickName = userNickName;
		this.userName = userName;
		this.userGender = userGender;
		this.userBio = userBio;
		this.joinDate = joinDate;
	}


}
