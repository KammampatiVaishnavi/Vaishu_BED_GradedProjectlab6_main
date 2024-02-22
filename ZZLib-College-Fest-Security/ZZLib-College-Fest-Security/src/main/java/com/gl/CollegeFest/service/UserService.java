
package com.gl.CollegeFest.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gl.CollegeFest.dto.SignUpDto;
import com.gl.CollegeFest.entity.User;

public interface UserService extends UserDetailsService{
	public User save(SignUpDto signUpDto);
}
