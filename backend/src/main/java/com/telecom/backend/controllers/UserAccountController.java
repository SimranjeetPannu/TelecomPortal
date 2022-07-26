package com.telecom.backend.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.telecom.backend.beans.UserAccount;
import com.telecom.backend.services.UserAccountService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/account")
public class UserAccountController {
	
	@Autowired
	private UserAccountService service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserAccount> findById(@PathVariable int id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/{customerID}/{deviceid}")
	public ResponseEntity<UserAccount> addDevice(@RequestBody int customerID, int deviceid) {
		service.addDevice(customerID, deviceid);
		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.CREATED);
	}

	@PostMapping("/{customerID}/{planid}")
	public ResponseEntity<UserAccount> addPlan(@RequestBody int customerID, int planid) {
		service.addPhonePlan(customerID, planid);
		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{customerID}/{deviceid}")
	public ResponseEntity<UserAccount> deleteDevice(@RequestBody int customerID, int deviceid) {
		service.deleteDevice(customerID, deviceid);
		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.GONE);
	}

	@DeleteMapping("/{customerID}/{planid}")
	public ResponseEntity<UserAccount> deletePlan(@RequestBody int customerID, int planid) {
		service.deletePhonePlan(customerID, planid);
		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.GONE);
}

}