package com.techguy.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.techguy.application.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}
