package com.yhdc.cedenti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index() {
		return "home/index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/updates")
	public String updates() {
		return "updates";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/board/browse")
	public String browse() {
		return "board/browse";
	}

	@GetMapping("/user/dashboard")
	public String dashboard() {
		return "user/dashboard";
	}

	@GetMapping("/user/profile")
	public String profile() {
		return "user/profile";
	}

	@GetMapping("/user/settings")
	public String settings() {
		return "user/settings";
	}
}
