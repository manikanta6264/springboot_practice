package com.practice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.practice.entities.UserDet;
import com.practice.repositories.IUserRepository;

@Component
public class SessionUserDetails {

	@Autowired
	private IUserRepository userRepo;
	
	public UserDet getSessionUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) auth.getPrincipal();
		UserDet userDet= userRepo.findByUserEmail(principal.getUsername());
		return userDet;
	}
}
