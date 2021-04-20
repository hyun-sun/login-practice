package com.itosamto.trpglab.common.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JasyptConfigTest {
	@Test
	public void jasypt_encrypt_decrypt_test() {
		String plainText = "";

		StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
		jasypt.setPassword("");
		jasypt.setAlgorithm("PBEWithMD5AndDES");

		String encryptedText = jasypt.encrypt(plainText);
		String decryptedText = jasypt.decrypt(encryptedText);

		System.out.println("=========== JASYPT ===============");
		System.out.println(plainText);
		System.out.println("ENC(" + encryptedText + ")");

		assertThat(plainText).isEqualTo(decryptedText);
	}
}
