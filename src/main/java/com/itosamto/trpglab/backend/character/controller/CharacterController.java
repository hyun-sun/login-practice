package com.itosamto.trpglab.backend.character.controller;

import com.itosamto.trpglab.backend.character.service.CharacterService;
import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/my/character")
public class CharacterController {

	final CharacterService characterService;

	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> list(HttpServletRequest request) {



		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 캐릭터 목록

	// 캐릭터 생성

	// 캐릭터 삭제

	// 캐릭터 상세



}
