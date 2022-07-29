package com.telecom.backend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.backend.beans.Device;
import com.telecom.backend.services.DeviceService;

@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/devices")
public class DeviceController {

  @Autowired
  DeviceService deviceService;
  
  // Just for testing
  @GetMapping("/authed")
  public ResponseEntity<List<Device>> getDevices(HttpServletResponse response) {
    List<Device> deviceData = deviceService.findAllDevices();
    if (!deviceData.isEmpty()) {
      return new ResponseEntity<>(deviceData, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<Device>> findById(@PathVariable("id") int id){
	  
	  try {
		  List<Device> devices = deviceService.findDevicesByPlanid(id);
		  if(devices == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
  
  @PostMapping("/newdevice")
  public ResponseEntity<Device> createDevice(@RequestBody Device device) {
    
    Device _device = deviceService.findById(device.getId());
    try {
      if(_device == null){
        _device = deviceService.add(new Device(device.getDeviceName(), device.getPhoneNumber(), device.getPlanid()));
        return new ResponseEntity<>(_device, HttpStatus.CREATED);
      }
      else{
        return new ResponseEntity<>(_device, HttpStatus.BAD_REQUEST);
      }
       
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<Device> updateDevice(@PathVariable("id") int id, @RequestBody Device device) {
    Device deviceData = deviceService.findById(id);
    if (deviceData != null) {
        deviceData.setDeviceName(device.getDeviceName());
        deviceData.setPhoneNumber(device.getPhoneNumber());
        deviceData.setPlanid(device.getPlanid());
      return new ResponseEntity<>(deviceService.add(deviceData), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteDevice(@PathVariable("id") int id) {
    try {
        deviceService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }  
}