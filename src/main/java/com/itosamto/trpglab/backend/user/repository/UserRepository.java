package com.itosamto.trpglab.backend.user.repository;

import com.itosamto.trpglab.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserEmailAndRegistrationId(String email, String registrationId);
}
