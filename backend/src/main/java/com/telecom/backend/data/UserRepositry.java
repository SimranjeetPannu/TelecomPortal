package com.telecom.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.backend.beans.Users;

@Repository
public interface UserRepositry extends JpaRepository<Users, Integer> {
  
	 
}
