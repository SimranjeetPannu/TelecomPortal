package com.telecom.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.backend.beans.Users;
import com.telecom.backend.data.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//Register the new user
	public Users register(Users user) {
		return userRepo.save(user);
	}
	
	//need code for find by username and login
	
	//List of all the customers
	public List<Users> findAll(){
		return userRepo.findAll();
	}
	
	//Find the customer by id
	public Optional<Users> findById(int id) {
		return userRepo.findById(id);
	}

	
	//delete the user
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

}
