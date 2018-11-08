package com.zhouce.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public Resource<User> retrieveUser(@PathVariable int uid) { // 这个@pathvariable是当用变量在url时必用的annotation
		User user = userdata.findOne(uid);
		if (user == null) { // 不做exception handle的话，即使用户不存在，也会默认200
			throw new UserNotFoundException("id-" + uid +"not found");
		}
		
		//HATEOAS    hypermedia as the engine of application state : 同样引入其他相关链接作为output
		
		// "all-users", SERVER_PATH + "/users"
		//retrieveAllUser
		
		Resource<User> resources = new Resource<User>(user);
		
		// get all the users of the userdata
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resources.add(linkTo.withRel("all-users"));
		//		return user;
		//    to use hateoas, we don't return user, we return resource of users(user and a set of links) back
		return resources;
	}
	
	//	input - details of user
	//  output - CREATED &Return the created URI
	@PostMapping("/users")
	public void createUser(@Valid @RequestBody User user) { // 这里的@valid是调用responseEntityExceptionHandler类中handleMethodArgumentNotValid这个函数, 这里相当于是个mark，真正对于validation的限制要写在实体里
		User savedUser = userdata.save(user);
	}
	
	//input id of user
	// output - delete that user by id
	@DeleteMapping("/users/{uid}")
	public void deleteUser(@PathVariable int uid) {
		User user = userdata.deleteById(uid);
		if (user == null) {
			throw new UserNotFoundException("id-" + uid +"not found");
		}
	}
}
