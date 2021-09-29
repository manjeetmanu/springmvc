package com.nagarro.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nagarro.springmvc.service.UserService;
import com.nagarro.springmvc.model.User;

/**
 * This class is handling the data coming from registeration.jsp file
 *
 */
@Controller
public class RegisterationController {

	@Autowired
	private UserService userservice;

	@RequestMapping("/registeration")
	public String showForm() {
		return "registeration";
	}

	@RequestMapping(path = "/processregisterform", method = RequestMethod.POST)
	public String handleRegisterFormdata(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		this.userservice.createUser(user);
		return "log-in";
	}

}