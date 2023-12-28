package com.lcwd.user.service.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.entities.User;

import com.lcwd.user.service.UserService.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//create
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userServiceImpl.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	//Single user get
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User user = userServiceImpl.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
	
	
	//all user get
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userServiceImpl.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
