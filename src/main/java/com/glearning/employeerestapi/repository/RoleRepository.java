package com.glearning.employeerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeerestapi.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
