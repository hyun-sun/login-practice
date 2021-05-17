package com.itosamto.loginpractice.config.security;

import com.itosamto.loginpractice.config.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.itosamto.loginpractice.config.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.itosamto.loginpractice.config.security.oauth2.user.Role;
import com.itosamto.loginpractice.config.security.oauth2.CustomOAuth2UserService;
import com.itosamto.loginpractice.config.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final HttpCookieOAuth2AuthorizationRequestRepository cookieOAuth2AuthorizationRequestRepository;
	private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
	private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}


	public SecurityConfig(CustomOAuth2UserService customOAuth2UserService,
	                      HttpCookieOAuth2AuthorizationRequestRepository cookieOAuth2AuthorizationRequestRepository,
	                      OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler,
	                      OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler) {
		this.customOAuth2UserService = customOAuth2UserService;
		this.cookieOAuth2AuthorizationRequestRepository = cookieOAuth2AuthorizationRequestRepository;
		this.oAuth2AuthenticationSuccessHandler = oAuth2AuthenticationSuccessHandler;
		this.oAuth2AuthenticationFailureHandler = oAuth2AuthenticationFailureHandler;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 스프링시큐리티가 생성하지도않고 기존것을 사용하지도 않음 (https://fenderist.tistory.com/342)
				.and()
			.csrf()
				.requireCsrfProtectionMatcher(new CsrfRequireMatcher())
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
			.formLogin().disable()
			.httpBasic().disable()
			.exceptionHandling()
				.authenticationEntryPoint(new RestAuthenticationEntryPoint())
				.and()
			.authorizeRequests()
				.antMatchers("/oauth2/**").permitAll()
				.antMatchers("swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**").hasRole(Role.USER.name())
				.antMatchers("/v1/**").hasRole(Role.USER.name())
				.anyRequest().authenticated()
				.and()
			.oauth2Login()
				.authorizationEndpoint()
				.baseUri("/oauth2/authorize")
				.authorizationRequestRepository(cookieOAuth2AuthorizationRequestRepository)
				.and()
				.redirectionEndpoint()
				.baseUri("/oauth2/callback/*")
				.and()
				.userInfoEndpoint().userService(customOAuth2UserService)
				.and()
			.successHandler(oAuth2AuthenticationSuccessHandler)
			.failureHandler(oAuth2AuthenticationFailureHandler);

		// LOGOUT
//		.logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID")
//				.and()
//				.oauth2Login()
//				.userInfoEndpoint()
//				.userService(customOAuth2UserService)

		// Add our custom Token based authentication filter
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
