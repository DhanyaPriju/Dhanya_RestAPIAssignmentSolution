package com.glearning.employeerestapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.employeerestapi.model.DomainUserDetails;
import com.glearning.employeerestapi.model.User;
import com.glearning.employeerestapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DomainUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = this.userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid User"));

		return new DomainUserDetails(user);
	}
}
