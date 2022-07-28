package com.telecom.backend.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telecom.backend.beans.PhonePlan;
import java.util.List;


public interface PhonePlanRepository extends JpaRepository<PhonePlan, Integer>{
	
	
	public PhonePlan findById(int id);
	
	@Query( "SELECT p FROM Plan p")
	public List<PhonePlan> findAllPlans();


	public PhonePlan findByPlanName(String planName);

	// Selects plans owned by specific user
	@Query( "SELECT p FROM Plan p WHERE p.userId = :id" )
    public List<PhonePlan> findPlanByUserId(@Param("id") int id);

	
}