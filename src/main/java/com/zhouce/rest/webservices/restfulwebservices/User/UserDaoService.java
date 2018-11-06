package com.zhouce.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

// to let spring manage it, using @component annotation
@Component
public class UserDaoService {
	
	// use static list to immitate the database's data
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	static {
		users.add(new User(1, "Adam", "Male", new Date()));
		users.add(new User(2, "Ni Die", "Male", new Date()));
		users.add(new User(3, "Ni Ma", "Female", new Date()));
	}

	//	List<User> findAll()
	public List<User> findAll() {
		return users;
	}
	
	//	User save(User user)
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	//	User findOne(int id)
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
 