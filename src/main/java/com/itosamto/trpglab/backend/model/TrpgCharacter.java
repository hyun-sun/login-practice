package com.itosamto.trpglab.backend.model;

import com.itosamto.trpglab.backend.character.repository.TrpgCharacterRepository;
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
public class TrpgCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer characterId;

	private Integer ownUserId;

	private String characterName;

	private String characterBio;

	private Timestamp regDate;

	private Integer regId;

	private Timestamp modDate;

	private Integer modId;

	public TrpgCharacter() { }

	@Builder
	public TrpgCharacter(Integer characterId, Integer ownUserId, String characterName) {
		this.characterId = characterId;
		this.ownUserId = ownUserId;
		this.characterName = characterName;
	}




}
