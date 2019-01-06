package com.techguy.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.techguy.application.model.Role;

public interface RoleService {
	ResponseEntity<Role> addRole(Role role);
	ResponseEntity<String> deleteRole(int id);
	ResponseEntity<Role> updateRole(int id , Role role);
	ResponseEntity<String> deleteAllRoles();
	List<Role> getAllRoles();
	ResponseEntity<Role> getRole(int id);
}
