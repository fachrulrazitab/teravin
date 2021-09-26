package com.fr.controller;

import java.util.ArrayList;
import java.util.List;

import com.fr.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fr.entity.User;
import com.fr.response.UserResponse;
import com.fr.service.UserService;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	UserService userService;


	@GetMapping("/users")
	public List<UserResponse> getAllStudents () {
		List<User> userList = userService.getAllStudents();
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		
		userList.stream().forEach(user -> {
			userResponseList.add(new UserResponse(user));
		});
		
		return userResponseList;
	}

	@PostMapping("user")
	public UserResponse createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
		User user = userService.createUser(createUserRequest);
		return new UserResponse(user);
	}
}
