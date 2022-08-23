package com.wipro.sfh.service;

import java.util.List;

import com.wipro.sfh.dto.UserDTO;
import com.wipro.sfh.entity.User;


public interface IUserService {

	public User addUser(UserDTO userDTO);

	public List<User> getAllUser();

	public User getUserById(long uid);
	
	public User getUserByUsername(String username);

	public User updateUser(UserDTO userDTO);

	public void deleteUser(long id);
	
}
