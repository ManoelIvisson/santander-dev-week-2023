package org.santander_dev_week_2023.service;

import org.santander_dev_week_2023.model.User;

public interface UserService {
	User findById(Long id);
	
	User create(User userToCreate);
}
