package com.telecom.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.telecom.backend.models.AccountModel;
import com.telecom.backend.services.UserAccountService;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/account")
public class UserAccountController {

	private static final Logger logger = Logger.getLogger(UserAccountController.class);
	
	@Autowired
	private UserAccountService service;
	
	
	@GetMapping("/{customerid}")
	public ResponseEntity<List<UserAccount>> findBycustomerid(@PathVariable int customerid) {
		logger.info("Query Made");
		return new ResponseEntity<List<UserAccount>>(service.findBycustomerid(customerid), HttpStatus.OK);
	}

// 	@PostMapping("/{customerID}/{deviceid}")
// 	public ResponseEntity<UserAccount> addDevice(@RequestBody int customerID, int deviceid) {
// 		service.addDevice(customerID, deviceid);
// 		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.CREATED);
// 	}

// 	@PostMapping("/{customerID}/{planid}")
// 	public ResponseEntity<UserAccount> addPlan(@RequestBody int customerID, int planid) {
// 		service.addPhonePlan(customerID, planid);
// 		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.CREATED);
// 	}
	
// 	@DeleteMapping("/{customerID}/{deviceid}")
// 	public ResponseEntity<UserAccount> deleteDevice(@RequestBody int customerID, int deviceid) {
// 		service.deleteDevice(customerID, deviceid);
// 		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.GONE);
// 	}

// 	@DeleteMapping("/{customerID}/{planid}")
// 	public ResponseEntity<UserAccount> deletePlan(@RequestBody int customerID, int planid) {
// 		service.deletePhonePlan(customerID, planid);
// 		return new ResponseEntity<UserAccount>(service.findById(customerID), HttpStatus.GONE);
// }

}