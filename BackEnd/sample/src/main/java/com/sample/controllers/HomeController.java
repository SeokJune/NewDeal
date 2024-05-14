package com.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("ASD");
		return "index.html";
	}
}
