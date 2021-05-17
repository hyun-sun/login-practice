package com.itosamto.loginpractice.config.security;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CsrfRequireMatcher implements RequestMatcher {
	private static final Pattern ALLOWED_METHODS = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	@Override
	public boolean matches(HttpServletRequest request) {
		if (ALLOWED_METHODS.matcher(request.getMethod()).matches())
			return false;

		String referer = request.getHeader("Referer");
		if (referer.contains("/swagger-ui"))
			return false;

		return true;
	}
}
