package com.itosamto.loginpractice.backend.trpgCharacter.service;

import com.itosamto.loginpractice.backend.trpgCharacter.dto.TrpgCharacterSaveDto;
import com.itosamto.loginpractice.backend.trpgCharacter.dto.TrpgCharacterSearchDto;
import com.itosamto.loginpractice.backend.trpgCharacter.repository.TrpgCharacterRepository;
import com.itosamto.loginpractice.backend.model.TrpgCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

	private final TrpgCharacterRepository trpgCharacterRepository;

	public CharacterService(TrpgCharacterRepository trpgCharacterRepository) {
		this.trpgCharacterRepository = trpgCharacterRepository;
	}

	public List<TrpgCharacter> list(TrpgCharacterSearchDto info) {
		List<TrpgCharacter> characters = trpgCharacterRepository.findByOwnUserId(info.getOwnUserId());
		return characters;
	}

	public TrpgCharacter createTrpgCharacter(TrpgCharacterSaveDto trpgCharacterSaveDto) {
		TrpgCharacter trpgCharacter = new TrpgCharacter(trpgCharacterSaveDto);
		trpgCharacter.insert(trpgCharacterSaveDto.getUserId());
		trpgCharacter = trpgCharacterRepository.save(trpgCharacter);
		return trpgCharacter;
	}

	public TrpgCharacter updateTrpgCharacter(TrpgCharacterSaveDto trpgCharacterSaveDto) {
		TrpgCharacter trpgCharacter = trpgCharacterRepository.findByCharacterId(trpgCharacterSaveDto.getCharacterId());
		trpgCharacter.update(trpgCharacterSaveDto);
		trpgCharacter = trpgCharacterRepository.save(trpgCharacter);
		return trpgCharacter;
	}

	public void deleteTrpgCharacter(Integer characterId) {
		trpgCharacterRepository.deleteById(characterId);

	}


}
