
package com.gl.CollegeFest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.CollegeFest.dto.SignUpDto;
import com.gl.CollegeFest.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByEmail(String Email);

	Optional<User> findByUsernameEmail(String Email, String userNameOrEmail);

	Optional<User> findByUsername(String Email);

	Boolean exsistByUsername(String username);

	Boolean exsistByEmail(String email);

	/**
	 * @param signUpDto
	 */
	void save(SignUpDto signUpDto);
}
