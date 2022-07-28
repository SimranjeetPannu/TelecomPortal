package com.telecom.backend.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.backend.beans.PhonePlan;
import com.telecom.backend.services.PlanService;
import com.telecom.backend.services.UserServiceV1;

@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/plans")
public class PhonePlanController {

  @Autowired
  PhonePlanService planService;
  
  // Just for testing
  @GetMapping("/authed")
  public ResponseEntity<List<PhonePlan>> getUsers(HttpServletResponse response) {
    List<PhonePlan> planData = planService.findAllPlans();
    response.getHeader("cookie");
    if (!planData.isEmpty()) {
      return new ResponseEntity<>(planData, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

    
  @GetMapping("/{id}")
  public ResponseEntity<List<PhonePlan>> findByUserId(@PathVariable("id") int id){
	  
	  try {
		  List<PhonePlan> plans = planService.findPlanByUserId(id);
		  if(plans == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<List<PhonePlan>>(plans, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
    @GetMapping("/plan/{id}")
  public ResponseEntity<PhonePlan> findByPlanId(@PathVariable("id") int id){
	  
	  try {
        PhonePlan plans = planService.findById(id);
		  if(plans == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<PhonePlan>(plans, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

    @PutMapping("/update/{id}")
  public ResponseEntity<PhonePlan> updateByPlanId(@PathVariable("id") int id, @RequestBody PhonePlan plan){
	  
	  try {
        PhonePlan newPlan = planService.findById(id);
		  if(newPlan == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
      newPlan.setPlanName(plan.getPlanName());
      newPlan.setPrice(plan.getPrice());
      newPlan.setDeviceLimit(plan.getDeviceLimit());
		  return new ResponseEntity<PhonePlan>(newPlan, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


  @PostMapping("/newplan")
  public ResponseEntity<PhonePlan> createPlan(@RequestBody PhonePlan plan) {
    PhonePlan _plan = planService.findById(plan.getId());
    try {
      if(_plan == null) {
        _plan = planService.add(new PhonePlan(plan.getPlanName(), plan.getDeviceLimit(), plan.getPrice(), plan.getUserId()));
      }
          
      return new ResponseEntity<>(_plan, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deletePlan(@PathVariable("id") int id) {
    try {
        planService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}