package com.telecom.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.backend.beans.PhonePlan;
import com.telecom.backend.services.PhoneplanService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/phoneplan")
public class PhoneplanController {

	
	@Autowired
    private PhoneplanService service;
	
	@GetMapping("/id/{id}")
    public ResponseEntity<Optional<PhonePlan>> findById(@PathVariable(value="id") int id) {
        return new ResponseEntity<Optional<PhonePlan>>(service.findById(id), HttpStatus.OK);
    }
	
	@GetMapping("/")
    public ResponseEntity<List<PhonePlan>> findAll() {
        return new ResponseEntity<List<PhonePlan>>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PhonePlan> save(@RequestBody PhonePlan PhonePlan) {
        return new ResponseEntity<PhonePlan>(service.save(PhonePlan), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value="id") int id) {
        service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
