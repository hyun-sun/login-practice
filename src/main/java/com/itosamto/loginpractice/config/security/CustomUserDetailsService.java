package com.itosamto.loginpractice.config.security;

import com.itosamto.loginpractice.backend.model.User;
import com.itosamto.loginpractice.backend.user.repository.UserRepository;
import com.itosamto.loginpractice.common.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUserEmail(userEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not fount with email : "+ userEmail));
		return UserPrincipal.create(user);
	}

	public UserDetails loadUserById(Integer id) {
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return UserPrincipal.create(user);
	}
}
