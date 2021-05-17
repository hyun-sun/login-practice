package com.itosamto.loginpractice.config.security.oauth2;

import com.itosamto.loginpractice.backend.model.User;
import com.itosamto.loginpractice.backend.user.repository.UserRepository;
import com.itosamto.loginpractice.config.security.UserPrincipal;
import com.itosamto.loginpractice.config.security.oauth2.user.OAuthAttributes;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	public CustomOAuth2UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);

		// 현재 로그인 진행 중인 서비스를 구분하는 코드
		String registrationId = userRequest.getClientRegistration().getRegistrationId();

		// OAuth2 로그인 진행 시 키가 되는 필드값
		String userNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

		// OAuth2Service를 통해서 가져온 OAuth2User 의 attribute
		OAuthAttributes attributes = OAuthAttributes.
				of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

		User user = saveOrUpdate(attributes);

		return UserPrincipal.create(user, oAuth2User.getAttributes());
	}

	private User saveOrUpdate(OAuthAttributes attributes) {
		User user = userRepository.findByUserEmailAndRegistrationId(attributes.getEmail(), attributes.getRegistrationId())
				.map(entity -> entity.update(attributes.getName(),attributes.getProfileUrl()))
				.orElse(attributes.toEntity());

		return userRepository.save(user);
	}
}
