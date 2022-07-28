package com.telecom.backend.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telecom.backend.beans.Users;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Users findById(int id);
	
	@Query( "SELECT u FROM UserClass u")
	public List<Users> findAllUsers();

	// Used by CustomUserDetailService
	public Users findByEmail(String email);

	
}