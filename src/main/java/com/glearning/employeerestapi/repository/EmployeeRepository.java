package com.glearning.employeerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.employeerestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
