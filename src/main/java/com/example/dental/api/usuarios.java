package com.example.dental.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class usuarios {
	
	@RequestMapping(value="hola",method=RequestMethod.GET)
	public String HolaMundo() {
		return "Hola Mundo";
	}
}
