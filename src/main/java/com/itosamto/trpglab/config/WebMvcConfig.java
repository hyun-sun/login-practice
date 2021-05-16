package com.itosamto.trpglab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// CORS 활성화
		// 프론트앤드 클라이언트가 다른 출처의 API 에 액세스할수 있도록
		long MAX_AGE_SECS = 3600;

		registry.addMapping("/**")
				.allowedOrigins("http//localhost:8080") // *
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(MAX_AGE_SECS);
	}
}
