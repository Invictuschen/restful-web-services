package com.zhouce.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	// inject userDaoService into it
	@Autowired
	private UserDaoService userdata;
	
	//retrieveAllUsers   GET /users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userdata.findAll();
	}
	
	//retrieveUser(int id) GET /users/{id}
	@GetMapping(path = "/users/{uid}") 
	public User retrieveUser(@PathVariable int uid) { // 这个@pathvariable是当用变量在url时必用的annotation
		User user = userdata.findOne(uid);
		if (user == null) { // 不做exception handle的话，即使用户不存在，也会默认200
			throw new UserNotFoundException("id-" + uid +"not found");
		}
		return user;
		
	}
	
	//	input - details of user
	//  output - CREATED &Return the created URI
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = userdata.save(user);
	}
}