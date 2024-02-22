
package com.gl.CollegeFest.service;

import java.util.Collections;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.CollegeFest.dto.SignUpDto;
import com.gl.CollegeFest.entity.User;
import com.gl.CollegeFest.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
	@Autowired

	UserRepository userRepository;

	@Autowired

	PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByUsernameEmail(userNameOrEmail,userNameOrEmail)
				.orElseThrow();
		()-> new UsernameNotFoundException("User not found with username or email:" +userNameOrEmail);
		Set<GrantedAuthority> authorities = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for(Role role: roles) {
			authorites.add(new SimpleGrantedAuthority(role.getName()));
		}


		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public User save(SignUpDto signUpDto) {
		Role roles = new Role(null, null);
		roles.setRoleName("ROLE_ADMIN");

		User user = new User(signUpDto.getname(),signUpDto.getUsername(),signUpDto.getEmail(),
				passwordEncoder.encode(signUpDto.getPassword()));
		User.setRoles(Collections.singleton(roles));
		;
		return userRepository.save(user);
	}

}
