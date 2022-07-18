package com.glearning.employeerestapi.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.glearning.employeerestapi.model.Role;
import com.glearning.employeerestapi.model.Employee;
import com.glearning.employeerestapi.model.User;
import com.glearning.employeerestapi.repository.RoleRepository;
import com.glearning.employeerestapi.repository.EmployeeRepository;
import com.glearning.employeerestapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BootStrapAppData implements ApplicationListener<ApplicationReadyEvent> {

	private final PasswordEncoder passwordEncoder;
	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// implement faker here
		for (int i = 0; i < 10; i++) {
			Employee employee = new Employee();
			employee.setFirstName("Sameer" + i);
			employee.setLastName("asd" + i);
			employee.setEmail("In" + i);
			employeeRepository.save(employee);
		}

		Role userRole = new Role();
		userRole.setRoleName("ROLE_USER");

		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");

		User user = new User();
		user.setUserName("dhanya");
		user.setPassword(this.passwordEncoder.encode("test123"));

		User admin = new User();
		admin.setUserName("satya");
		admin.setPassword(this.passwordEncoder.encode("testadmin"));

		admin.addRole(adminRole);
		admin.addRole(userRole);

		user.addRole(userRole);

		userRepository.save(user);
		userRepository.save(admin);

		roleRepository.save(userRole);
		roleRepository.save(adminRole);
	}

}
