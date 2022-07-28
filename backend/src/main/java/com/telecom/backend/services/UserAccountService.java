package com.telecom.backend.services;

import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.backend.beans.UserAccount;
import com.telecom.backend.data.UserAccountRepository;

@Service
public class UserAccountService {

	private static final Logger logger = Logger.getLogger(UserAccountService.class);

	@Autowired
	private UserAccountRepository userRepo;
	
	 // Add a device to their account
	// public UserAccount addDevice(int customerID, int deviceid) {
	// 	userRepo.findById(customerID).get().setDeviceid(deviceid);
	// 	return userRepo.findById(customerID).get();
	//  }
	
	// // Add a Phone Plan to their account
	// public UserAccount addPhonePlan(int customerID, int planid) {
	// 	userRepo.findById(customerID).get().setPlanid(planid);
	// 	return userRepo.findById(customerID).get();
	// }

	// // Delete a device from their account
	// public Optional<UserAccount> deleteDevice(int customerID, int deviceid) {
	// 	userRepo.deleteById(deviceid);
	// 	return userRepo.findById(customerID);
	// }

	// // Delete a Phone Plan from their account
	// public Optional<UserAccount> deletePhonePlan(int customerID, int planid) {
	// 		userRepo.deleteById(planid);
	// 		return userRepo.findById(customerID);
	// }

	//need code for find by username and login
	
	//List of all the customers
	public List<UserAccount> findAll(){
		return userRepo.findAll();
	}
	
	//Find the customer by id
	// public List<UserAccount> findByCustomerid(int customerid) {
	// logger.info("Query Made");
	// return userRepo.findBycustomerid(customerid);
	// }

	//  public List<AccountModel> findBycustomerid (int customerid) {
	//  AccountModel account;
	//  Optional<UserAccount> temp = userRepo.findById(customerid);
	
	//  for (AccountModel temp : customerid) {

	//  	account = new AccountModel(temp.get());
	//  }

	//  return account;
	//  }

	public List<UserAccount> findByCustomerId(int customerId) {
		logger.info("Query Made");
		return userRepo.findBycustomerId(customerId);
	}

}
