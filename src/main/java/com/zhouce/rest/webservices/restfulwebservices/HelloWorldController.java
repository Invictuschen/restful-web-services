package com.zhouce.rest.webservices.restfulwebservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 1.Tell spring that this is a controller
@RestController
public class HelloWorldController {
	// GET
	// URI   -/hello-world
	// method return "helloworld"
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	// this is as a simple serivce that provide the resource, the controller get whatever you return
	public Map<String, String> helloWorld() {
		Map<String, String> map = new HashMap<>();
		map.put("WTF", "HelloWorld");
		return map;
	}
}
 