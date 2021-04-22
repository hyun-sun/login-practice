package com.itosamto.trpglab.backend.character.service;

import com.itosamto.trpglab.backend.character.repository.TrpgCharacterRepository;
import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

	private final TrpgCharacterRepository trpgCharacterRepository;

	public CharacterService(TrpgCharacterRepository trpgCharacterRepository) {
		this.trpgCharacterRepository = trpgCharacterRepository;
	}

	public TrpgCharacter list() {
		// return trpgCharacterRepository.findBy;
		return null;
	}
}
