
package com.gl.CollegeFest.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/")
	public String showLogin(Model model) {
		User user = new User(null, null, null);
		model.addAttribute("user", user);
		System.out.println("Reg");
		return "login";

	}
}
