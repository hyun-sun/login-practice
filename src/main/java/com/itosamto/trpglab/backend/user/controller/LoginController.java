package com.itosamto.trpglab.backend.user.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oauth2/callback")
@Slf4j
public class LoginController {

	@GetMapping("/google")
	public String googleCallback(String code) {
		return code;
	}


	@GetMapping("/kakao")
	public String kakaoCallback(String code) {
		log.info("kakao loginCode : " + code);
		return code;
	}
}
