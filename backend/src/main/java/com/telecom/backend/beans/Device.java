package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int deviceid;
	    
	 @Column
	 private String name;
	    
	 @Column
	 private int price;

	 public Device() {

	 }

	public Device(int deviceid, String name, int price) {
		this.deviceid = deviceid;
		this.name = name;
		this.price = price;
	}

	public int getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Device [deviceid=" + deviceid + ", name=" + name + ", price=" + price + "]";
	}

	 
}

	