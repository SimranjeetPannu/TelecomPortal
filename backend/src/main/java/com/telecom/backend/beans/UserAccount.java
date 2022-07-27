package com.telecom.backend.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerid;
	
	@Column
	private int planid;
	
	@Column
	private int deviceid;
	
	@Column
	private double monthlybill;
	

	@OneToMany(mappedBy = "planid")
	private Set<PhonePlan> plan;

	@OneToMany(mappedBy = "deviceid")
	private Set<Device> device;
	
	//@OneToMany
	//@JoinColumn(name="deviceId")
	//private PhonePlan phoneplan;
	//________________________________________________
	
	
	
	public UserAccount() { }

	public UserAccount(int customerid, int planid, int deviceid, double monthlybill) {
		super();
		this.customerid = customerid;
		this.planid = planid;
		this.deviceid = deviceid;
		this.monthlybill = monthlybill;
	}
	
	public int getcustomerid() {
		return customerid;
	}

	public void setcustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public int getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}

	public double getMonthlybill() {
		return monthlybill;
	}

	public void setMonthlybill(double monthlybill) {
		this.monthlybill = monthlybill;
	}

	@Override
	public String toString() {
		return "UserAccount [customerid=" + customerid + ", planid=" + planid + ", deviceid=" + deviceid
				+ ", monthlybill=" + monthlybill + "]";
	}
	
	

}
