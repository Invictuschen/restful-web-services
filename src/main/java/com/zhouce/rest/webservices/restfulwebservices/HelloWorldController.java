package com.zhouce.rest.webservices.restfulwebservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 1.Tell spring that this is a controller
@RestController
public class HelloWorldController {
	// GET
	// URI   -/hello-world
	// method return "helloworld"
	@RequestMapping (method = RequestMethod.GET, path = "/hello-world")
	// this is as a simple serivce that provide the resource, the controller get whatever you return
	public Map<String, String> hello_World() {
		Map<String, String> map = new HashMap<>();
		map.put("WTF", "HelloWorld");
		return map;
	}
	// a easier way to use get method
	@GetMapping (path = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping (path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(String message) {
		return new HelloWorldBean("Hello World : this is created by bean");
	}
	
	//hello-world/path-variable/zhouce
	// pay attention, here the {variable} means the variable that the uri should receive, the name must be equal to the name in the service function
	@GetMapping (path = "/hello-world/path-variable/{variable}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String variable) {
		return new HelloWorldBean(String.format("Hello World, %s", variable + " (this is created by bean and receive variable as the uri)"));
	}
}
 