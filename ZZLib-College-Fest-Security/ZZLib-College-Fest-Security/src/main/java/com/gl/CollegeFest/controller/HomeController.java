
package com.gl.CollegeFest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showHome() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "accessDenied";
	}
}