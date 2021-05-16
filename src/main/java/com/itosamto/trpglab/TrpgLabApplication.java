package com.itosamto.trpglab;

import com.itosamto.trpglab.config.AppProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableEncryptableProperties
@EnableConfigurationProperties(AppProperties.class)
public class TrpgLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrpgLabApplication.class, args);
	}

}
