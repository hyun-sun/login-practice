package com.itosamto.trpglab.backend.user.repository;

import com.itosamto.trpglab.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserEmail(String email);
	Optional<User> findByUserEmailAndRegistrationId(String email, String registrationId);
}
