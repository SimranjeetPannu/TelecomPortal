package com.telecom.backend.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.backend.beans.Device;
import com.telecom.backend.data.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository repo;
	
	public Device findById(int id){
		return repo.findById(id);
	}

	public List<Device> findAllDevices(){
		return repo.findAllDevices();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Device add(Device device) {
		return repo.save(device);
	}

	@Transactional()
	public void delete(int deviceId) {
		repo.delete(findById(deviceId));
	}

	public List<Device> findDevicesByPlanid(int planid) {
		return repo.findDevicesByPlanid(planid);
	}
}