package com.telecom.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.telecom.backend.beans.Users;
import com.telecom.backend.data.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public Users findById(int id){
		return repo.findById(id);
	}

	public List<Users> findAllUsers(){
		return repo.findAllUsers();
	}

	public Users findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Users add(Users user) {
		return repo.save(user);
	}

	@Transactional()
	public void delete(int user_id) {
		repo.delete(findById(user_id));
	}
}