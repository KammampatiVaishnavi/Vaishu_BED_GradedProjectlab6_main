
package com.gl.CollegeFest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.CollegeFest.dto.SignUpDto;
import com.gl.CollegeFest.service.UserService;

@Controller
public class UserRegistrationController {
	@Autowired
	private UserService userService;
	@GetMapping("/registration")
	public String showHome(Model model) {
		User user = new User(null, null, false, false, false, false, null);
		model.addAttribute("user", user);
		System.out.println("Reg");
		return "registration";
	}

	@PostMapping("/regSuccess")
	public String regUser(Model model, @ModelAttribute SignUpDto signUpDto) {
		userService.save(signUpDto);
		return "redirect:/registration?success";
	}
}
