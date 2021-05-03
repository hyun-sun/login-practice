package com.itosamto.trpglab.backend.trpgCharacter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrpgCharacterSearchDto {

	private Integer ownUserId;

	private String characterName;

}
