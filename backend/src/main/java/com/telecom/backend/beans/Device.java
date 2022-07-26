package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int deviceid;
	    
	 @Column
	 private String model;
	    
	 @Column
	 private int devicecost;

	 public Device() {

	}

	public Device(int deviceid, String model, int devicecost) {
		this.deviceid = deviceid;
		this.model = model;
		this.devicecost = devicecost;
	}

	public int getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDevicecost() {
		return devicecost;
	}

	public void setDevicecost(int devicecost) {
		this.devicecost = devicecost;
	}

	@Override
	public String toString() {
		return "Device [devicecost=" + devicecost + ", deviceid=" + deviceid + ", model=" + model + "]";
	}

}

	