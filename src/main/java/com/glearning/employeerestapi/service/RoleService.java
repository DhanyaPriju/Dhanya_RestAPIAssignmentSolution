package com.glearning.employeerestapi.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.glearning.employeerestapi.model.Employee;
import com.glearning.employeerestapi.model.Role;
import com.glearning.employeerestapi.repository.EmployeeRepository;
import com.glearning.employeerestapi.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
	private final RoleRepository roleRepository;

	@Transactional
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Transactional
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Transactional
	public Role findById(int id) {
		return roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No role found."));
	}

	@Transactional
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
	}

	@Transactional
	public Role updateRole(Role role, int roleId) {
		return roleRepository.save(role);
	}
}
