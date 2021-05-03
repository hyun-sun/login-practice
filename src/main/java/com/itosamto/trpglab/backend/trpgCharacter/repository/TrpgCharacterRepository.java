package com.itosamto.trpglab.backend.trpgCharacter.repository;

import com.itosamto.trpglab.backend.model.TrpgCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrpgCharacterRepository extends JpaRepository<TrpgCharacter, Integer> {

	TrpgCharacter findByCharacterId(Integer characterId);
	List<TrpgCharacter> findByOwnUserId(Integer ownUserId);
}
