package com.itosamto.loginpractice.backend.trpgCharacter.controller;

import com.itosamto.loginpractice.backend.trpgCharacter.dto.TrpgCharacterSaveDto;
import com.itosamto.loginpractice.backend.trpgCharacter.dto.TrpgCharacterSearchDto;
import com.itosamto.loginpractice.backend.trpgCharacter.service.CharacterService;
import com.itosamto.loginpractice.backend.model.TrpgCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/my/character")
public class TrpgCharacterController {

	final CharacterService characterService;

	public TrpgCharacterController(CharacterService characterService) {
		this.characterService = characterService;
	}

	@GetMapping
	public ResponseEntity<?> list(HttpSession session) {
		TrpgCharacterSearchDto searchDto = new TrpgCharacterSearchDto();
		// searchDto.setOwnUserId(getUserInfo(session).getUserId());
		List<TrpgCharacter> list = characterService.list(searchDto);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 캐릭터 생성
	@PostMapping
	public ResponseEntity<?> create(HttpSession session, @RequestBody TrpgCharacterSaveDto trpgCharacterSaveDto) {
		// trpgCharacterSaveDto.setUserId(getUserInfo(session).getUserId());
		TrpgCharacter trpgCharacter = characterService.createTrpgCharacter(trpgCharacterSaveDto);
		return new ResponseEntity<>(trpgCharacter, HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<?> update(HttpSession session, @RequestBody TrpgCharacterSaveDto trpgCharacterSaveDto) {
		// trpgCharacterSaveDto.setUserId(getUserInfo(session).getUserId());
		TrpgCharacter trpgCharacter = characterService.updateTrpgCharacter(trpgCharacterSaveDto);
		return new ResponseEntity<>(trpgCharacter, HttpStatus.OK);
	}

	// 캐릭터 삭제
	@DeleteMapping
	public ResponseEntity<?> delete(HttpSession session, @RequestParam String characterId) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 캐릭터 상세

	// FIXME
	private String getUserInfo(HttpSession httpSession) {
		return null;
	}


}
