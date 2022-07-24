package com.telecom.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.backend.beans.PhonePlan;
import com.telecom.backend.data.PhoneplanRepository;

@Service
public class PhoneplanService {
	
	@Autowired
	private PhoneplanRepository repository;
	
	public PhonePlan save(PhonePlan plan) {
		return repository.save(plan);
	}
	
	public Optional<PhonePlan> findById(int id) {
		return repository.findById(id);
	}
	
	public List<PhonePlan> findAll() {
		return repository.findAll();
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	

}
