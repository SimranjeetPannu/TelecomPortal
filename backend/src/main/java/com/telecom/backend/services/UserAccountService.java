package com.telecom.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.backend.beans.UserAccount;
import com.telecom.backend.data.UserAccountRepository;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountRepository repository;
	
	//List of all the customers
		public List<UserAccount> findAll(){
			return repository.findAll();
		}
		
		//Find the customer by id
		public Optional<UserAccount> findById(int id) {
			return repository.findById(id);
		}


}
