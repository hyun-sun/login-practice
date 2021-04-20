package com.itosamto.trpglab.backend.character.repository;

import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrpgCharacterRepository extends JpaRepository<TrpgCharacter, Integer> {

	TrpgCharacter findByCharacterId(Integer characterId);
}
