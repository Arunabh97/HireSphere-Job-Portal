package com.spring.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
