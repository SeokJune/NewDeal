package com.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public String home() {
		return "index.html";
	}
}
