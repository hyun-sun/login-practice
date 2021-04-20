package com.itosamto.trpglab;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class TrpgLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrpgLabApplication.class, args);
	}

}
