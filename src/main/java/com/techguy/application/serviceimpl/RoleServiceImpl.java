package com.techguy.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.techguy.application.model.Role;
import com.techguy.application.repository.RoleRepository;
import com.techguy.application.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<Role> addRole(Role role) {
		return new ResponseEntity<>(roleRepository.save(role), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteRole(int id) {
		Optional<Role> roleData = roleRepository.findById(id);
		if (roleData.isPresent()) {
			roleRepository.deleteById(id);
			return new ResponseEntity<>("Successfully deleted role : " + id, HttpStatus.OK);
		}
		return new ResponseEntity<>("Unsuccessful to delete role : " + id, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Role> updateRole(int id, Role role) {
		Optional<Role> roleData = roleRepository.findById(id);
		if (roleData.isPresent()) {
			Role roleDetails = new Role();
			roleDetails = roleData.get();
			roleDetails.setName(role.getName());
			return new ResponseEntity<>(roleRepository.save(roleDetails), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<String> deleteAllRoles() {
		try {
			roleRepository.deleteAll();
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("Unsuccessful", HttpStatus.NOT_FOUND);
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roleData = new ArrayList<>();
		roleRepository.findAll().forEach(roleData::add);
		return roleData;
	}

	@Override
	public ResponseEntity<Role> getRole(int id) {
		Optional<Role> roleData = roleRepository.findById(id);
		if (roleData.isPresent()) {
			Role roleDetails = roleData.get();
			return new ResponseEntity<>(roleDetails, HttpStatus.OK);
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}

}
