package com.glearning.employeerestapi.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

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

	// Save or Create operation
	@Transactional
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	// Read operation
	@Transactional
	public List<User> fetchUserList() {

		return userRepository.findAll();
	}

	// Update Operation
	@Transactional
	public User updateUser(User user, long userId) {

		User userDB = userRepository.findById(userId).get();

		if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
			userDB.setUserName(user.getUserName());
		}

		return userRepository.save(userDB);
	}

	// Delete Operation
	@Transactional
	public void deleteUserById(long userId) {

		userRepository.deleteById(userId);

	}

	// Find User by ID
	@Transactional
	public User getUser(long Id) {

		return userRepository.getById(Id);

	}
}
