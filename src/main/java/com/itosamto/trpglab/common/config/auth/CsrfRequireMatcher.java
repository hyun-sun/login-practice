package com.itosamto.trpglab.common.config.auth;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CsrfRequireMatcher implements RequestMatcher {
	private static final Pattern ALLOWED_METHODS = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	@Override
	public boolean matches(HttpServletRequest request) {
		if (ALLOWED_METHODS.matcher(request.getMethod()).matches()
				|| request.getHeader("Referer").contains("/swagger-ui"))
			return false;

		return true;
	}
}
