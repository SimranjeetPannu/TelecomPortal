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

import com.telecom.backend.beans.Device;
import com.telecom.backend.services.DeviceService;

@RestController
@RequestMapping("/devices")
//@CrossOrigin("http://localhost:?")
public class DeviceController {
	
	@Autowired
    private DeviceService dservice;

   

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Device>> findById(@PathVariable(value="id") int id) {
        return new ResponseEntity<Optional<Device>>(dservice.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Device>> findAll() {
        return new ResponseEntity<List<Device>>(dservice.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Device> save(@RequestBody Device device) {
        return new ResponseEntity<Device>(dservice.save(device), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value="id") int id) {
        dservice.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

