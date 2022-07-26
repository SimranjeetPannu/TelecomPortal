package com.telecom.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.backend.beans.UserAccount;
import com.telecom.backend.services.UserAccountService;

@RestController
@RequestMapping("/account/v1")
//@CrossOrigin("http://localhost:4200")
public class UserAccountController {
	
	@Autowired
	UserAccountService service;
	
	@GetMapping
	public ResponseEntity<List<UserAccount>> findAll(){ 
        return new ResponseEntity<List<UserAccount>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UserAccount>> findById(@PathVariable (value="id") int id){ 
        return new ResponseEntity<Optional<UserAccount>>(service.findById(id), HttpStatus.OK);
	}
	
	


}
