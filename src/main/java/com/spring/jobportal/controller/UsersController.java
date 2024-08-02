package com.spring.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.jobportal.entity.Users;
import com.spring.jobportal.entity.UsersType;
import com.spring.jobportal.services.UsersTypeService;

@Controller
public class UsersController {

	private final UsersTypeService usersTypeService;
	
	@Autowired
	public UsersController(UsersTypeService usersTypeService) {
		this.usersTypeService = usersTypeService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());
		return "register";
	}
}
