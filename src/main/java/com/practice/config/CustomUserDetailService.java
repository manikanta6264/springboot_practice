package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.entities.UserDet;
import com.practice.repositories.IUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDet userDet = userRepo.findByUserEmail(username);
		return new User(userDet.getUserEmail(), userDet.getPassword(), userDet.getRoles());
	}

}
