package com.zhouce.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	private String message;
	public HelloWorldBean(String message) {
		this.message = message;
	}
	// if this bean doesn't have the getter function, the uri cannot be access to get the resource, it will return http status = 500
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	// here we use the format to make the String result as a json
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}
}
