package com.spring.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.jobportal.services.UsersService;

@Controller
public class JobPostActivityController {

	public final UsersService usersService;

	@Autowired
	public JobPostActivityController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@GetMapping("/dashboard")
	public String searchJobs(Model model) {
		
		Object currentUserProfile = usersService.getCurrentUserProfile();
				
		return "dashboard";
	}
}
