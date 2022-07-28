package com.telecom.backend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.backend.beans.Users;
import com.telecom.backend.services.UserService;

@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  UserService userService;
  
  // Just for testing
  @GetMapping("/authed")
  public ResponseEntity<?> getUsers(HttpServletResponse response) {
    List<Users> userData = userService.findAllUsers();
    response.getHeader("cookie");
    if (!userData.isEmpty()) {
      return new ResponseEntity<>("userData", HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

    
  @GetMapping("/{email}")
  public ResponseEntity<Users> findById(@PathVariable("email") String email){
	  
	  try {
		  Users users = userService.findByEmail(email);
		  if(users == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<Users>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

  @PostMapping("/signup")
  public ResponseEntity<Users> createUser(@RequestBody Users user) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    try {
      Users _user = userService
          .add(new Users(user.getUserName(), user.getEmail(), encoder.encode(user.getPassword())));
      return new ResponseEntity<>(_user, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Users> updateUser(@PathVariable("id") int id, @RequestBody Users user) {
    Users userData = userService.findById(id);
    if (userData != null) {
      userData.setUserName(user.getUserName());
      userData.setEmail(user.getEmail());
      userData.setEmail(user.getPassword());
      return new ResponseEntity<>(userService.add(userData), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
    try {
      userService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}