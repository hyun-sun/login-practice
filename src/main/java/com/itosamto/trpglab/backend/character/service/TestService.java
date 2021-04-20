package com.itosamto.trpglab.backend.character.service;

import com.itosamto.trpglab.backend.character.repository.TrpgCharacterRepository;
import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private final TrpgCharacterRepository trpgCharacterRepository;

	public TestService(TrpgCharacterRepository trpgCharacterRepository) {
		this.trpgCharacterRepository = trpgCharacterRepository;
	}

	public TrpgCharacter test() {
		return trpgCharacterRepository.findByCharacterId(1);
	}
}
