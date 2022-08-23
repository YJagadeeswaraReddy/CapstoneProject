package com.wipro.sfh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.sfh.dto.UserDTO;
import com.wipro.sfh.entity.User;
import com.wipro.sfh.repository.UserRepository;
import com.wipro.sfh.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(UserDTO user) {
		User newUser = new User();

		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setPhone(user.getPhone());
		newUser.setRole("ROLE_USER");

		return userRepository.save(newUser);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long uid) {
		return userRepository.findById(uid).orElse(new User());
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElse(new User());
	}

	@Override
	public User updateUser(UserDTO user) {

		User updateUser = getUserByUsername(user.getUsername());

		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setEmail(user.getEmail());
		updateUser.setUsername(user.getUsername());
		updateUser.setPhone(user.getPhone());
		updateUser.setPassword(user.getPassword());
		updateUser.setRole(updateUser.getRole());

		return userRepository.save(updateUser);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
