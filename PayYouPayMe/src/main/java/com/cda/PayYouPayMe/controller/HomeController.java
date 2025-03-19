package com.cda.PayYouPayMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//@GetMapping("/home")
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}
