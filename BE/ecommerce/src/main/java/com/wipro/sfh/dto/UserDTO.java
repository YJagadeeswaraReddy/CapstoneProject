package com.wipro.sfh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Long phone;
	private String role;
}
