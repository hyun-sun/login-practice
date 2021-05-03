package com.itosamto.trpglab.backend.model;

import com.itosamto.trpglab.backend.trpgCharacter.dto.TrpgCharacterSaveDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

	private String profileUrl;

	private String characterBio;

	@CreatedDate
	private Timestamp regDate;

	private Integer regId;

	@LastModifiedDate
	private Timestamp modDate;

	private Integer modId;

	public TrpgCharacter() { }

	public TrpgCharacter(TrpgCharacterSaveDto trpgCharacterSaveDto) {
		this.characterName = trpgCharacterSaveDto.getCharacterName();
		this.profileUrl = trpgCharacterSaveDto.getProfileUrl();
		this.characterBio = trpgCharacterSaveDto.getCharacterBio();
	}

	@Builder
	public TrpgCharacter(Integer characterId,
	                     Integer ownUserId,
	                     String characterName,
	                     String profileUrl,
	                     String characterBio,
	                     Timestamp regDate,
	                     Integer regId,
	                     Timestamp modDate,
	                     Integer modId) {
		this.characterId = characterId;
		this.ownUserId = ownUserId;
		this.characterName = characterName;
		this.profileUrl = profileUrl;
		this.characterBio = characterBio;
		this.regDate = regDate;
		this.regId = regId;
		this.modDate = modDate;
		this.modId = modId;
	}

	public TrpgCharacter insert(Integer userId) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.ownUserId = userId;
		this.regDate = timestamp;
		this.regId = userId;
		return this;
	}

	public TrpgCharacter update(TrpgCharacterSaveDto trpgCharacterSaveDto) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.characterId = trpgCharacterSaveDto.getCharacterId();
		this.modDate = timestamp;
		this.modId = trpgCharacterSaveDto.getUserId();
		return this;
	}




}
