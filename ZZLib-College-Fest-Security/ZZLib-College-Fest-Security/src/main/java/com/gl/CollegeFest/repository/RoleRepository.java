
package com.gl.CollegeFest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.CollegeFest.entity.Role;
import com.gl.CollegeFest.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<User> findByName(String name);
}
