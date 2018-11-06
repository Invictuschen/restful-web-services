package com.zhouce.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.Iterator;
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
	
	//User delete(int id)
	public User deleteById(int id) {
		Iterator<User> iter = users.iterator(); // 用iterator的原因是你不需要知道数据的储存结构就可以遍历数据，也方便数据结构的改变
		while (iter.hasNext()) {
			User user = iter.next();
			if (user.getId() == id) {
//				users.remove(user);
				iter.remove(); // 在iter上remove就是相当于在list里remove
				return user;
			}
		}
		return null;
	}
}
 