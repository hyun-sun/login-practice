package com.itosamto.trpglab.common.config.auth;

import com.itosamto.trpglab.common.config.auth.enums.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
		this.customOAuth2UserService = customOAuth2UserService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**").hasRole(Role.USER.name())
				.antMatchers("/oauth2/**").permitAll()
				.antMatchers("/v1/**").hasRole(Role.USER.name())
				.anyRequest().authenticated()
				.and()
				.logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.and()
				.oauth2Login()
				.userInfoEndpoint()
				.userService(customOAuth2UserService);

		http.csrf()
				.requireCsrfProtectionMatcher(new CsrfRequireMatcher())
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}
