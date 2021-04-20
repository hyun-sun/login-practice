package com.itosamto.trpglab.backend.character.controller;

import com.itosamto.trpglab.backend.character.service.TestService;
import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	final TestService testService;

	public TestController(TestService testService) {
		this.testService = testService;
	}

	@GetMapping(value = "/test")
	public ResponseEntity<String> test() {
		String re = "test";
		TrpgCharacter trpgCharacter = testService.test();
		return new ResponseEntity<>(trpgCharacter.getCharacterName(), HttpStatus.OK);
	}

}
