package com.glearning.employeerestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeerestapi.model.Role;
import com.glearning.employeerestapi.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleManagmentController {
	private final RoleService roleService;

	@GetMapping
	public List<Role> fetchRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@PutMapping("/{id}")
	public Role updateRole(@RequestBody Role role, @PathVariable("id") int roleId) {
		return roleService.updateRole(role, roleId);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRole(@PathVariable("id") int roleId) {
		roleService.deleteRole(roleId);
	}
}
