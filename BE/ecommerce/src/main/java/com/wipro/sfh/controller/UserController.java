package com.wipro.sfh.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.sfh.dto.UserDTO;
import com.wipro.sfh.entity.User;
import com.wipro.sfh.service.IUserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping("/getall")
	public List<User> getAllUser() {
		return service.getAllUser();
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody UserDTO dto) {
		return service.addUser(dto);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		try {
			User user = service.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		try {
			User user = service.getUserByUsername(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody UserDTO user) {
		try {
			User updateUser = service.updateUser(user);
			return new ResponseEntity<User>(updateUser, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			service.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}