package com.spring.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jobportal.entity.JobSeekerProfile;
import com.spring.jobportal.entity.RecruiterProfile;
import com.spring.jobportal.entity.Users;
import com.spring.jobportal.repository.JobSeekerProfileRepository;
import com.spring.jobportal.repository.RecruiterProfileRepository;
import com.spring.jobportal.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	private final RecruiterProfileRepository recruiterProfileRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
		this.usersRepository = usersRepository;
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
		this.recruiterProfileRepository = recruiterProfileRepository;
	}
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		Users savedUsers = usersRepository.save(users);
		int userTypeId = users.getUserTypeId().getUserTypeId();
		
		if(userTypeId == 1) {
			recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
		}
		else {
			jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
		}
			
		return savedUsers;
	}
	
	public Optional<Users> getUserByEmail(String email){
		return usersRepository.findByEmail(email);
	}
}
