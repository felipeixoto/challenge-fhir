package com.leonardo.challenge.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leonardo.challenge.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = Logger.getLogger(UserService.class.getName());

	@Autowired
	UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("Verifying authentication for " + username);

		var user = repository.findByUsername(username);

		if (user != null) {
			logger.info("User " + username + " authenticated!");
			return user;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
	}

}
