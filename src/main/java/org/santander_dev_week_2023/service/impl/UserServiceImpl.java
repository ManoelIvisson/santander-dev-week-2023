package org.santander_dev_week_2023.service.impl;

import java.util.NoSuchElementException;

import org.santander_dev_week_2023.model.User;
import org.santander_dev_week_2023.repository.UserRepository;
import org.santander_dev_week_2023.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This account number already exists");
		}
		return userRepository.save(userToCreate);
	}

}
