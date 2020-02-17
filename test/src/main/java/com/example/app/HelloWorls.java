package com.example.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller  
@RestController
public class HelloWorls {

	// Using get method and hello-world as URI
	// http://localhost:8080/hello-world
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// Makes the word you type comes back in reverse
	// http://localhost:8080/score?rev=Fatmir
	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String update(String rev) {
		StringBuilder sb = new StringBuilder(rev);

		return sb.reverse().toString();
	}

	// Makes the the average of a number
	// http://localhost:8080/average?one=1&two=2&three=4
	@RequestMapping(value = "/average", method = RequestMethod.GET)
	public double getAverage(double one, double two, double three) {

		double ave = (one + two + three) / 3;
		return ave;

	}

	// Multiply two numbers
	// http://localhost:8080/mulit?one=1&two=5
	@RequestMapping(value = "/multi", method = RequestMethod.GET)
	public int multiply(int one, int two) {

		int multi = one * two;
		return multi;

	}

	// Subtract two numbers
	// http://localhost:8080/sub?one=2&two=3
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public int subtract(int one, int two) {

		int difference = one - two;
		return difference;

	}

}