package com.telecom.backend.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.backend.beans.PhonePlan;
import com.telecom.backend.data.PhonePlanRepository;

@Service
public class PhonePlanService {
	
	@Autowired
	private PhonePlanRepository repository;
	
	public PhonePlan findById(int id){
		return repository.findById(id);
	}

	public List<PhonePlan> findAllPlans(){
		return repository.findAllPlans();
	}
	
	public List<PhonePlan> findPlanByUserId(int customerid) {
		return repository.findPlanByUserId(customerid);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public PhonePlan add(PhonePlan plan) {
		return repository.save(plan);
	}

	@Transactional()
	public void delete(int planid) {
		repository.delete(findById(planid));
	}
}