package com.itosamto.trpglab.backend.trpgCharacter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrpgCharacterSaveDto {

	private Integer userId;

	private Integer characterId;

	private String characterName;

	private String profileUrl;

	private String characterBio;




}
