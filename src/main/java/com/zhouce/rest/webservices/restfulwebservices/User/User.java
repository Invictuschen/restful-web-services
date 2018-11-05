package com.zhouce.rest.webservices.restfulwebservices.User;

import java.util.Date;

public class User {
	private Integer id; // **very important**
	
	private String name;
	
	private String gender;
	
	private Date birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, gender=%s, birthDate=%s]", id, name, gender, birthDate);
	}

	public User(Integer id, String name, String gender, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
}
