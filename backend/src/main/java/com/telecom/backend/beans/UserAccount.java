package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerID;
	
	@Column
	private int planid;
	
	@Column
	private int deviceid;
	
	@Column
	private double monthlybill;
	
	//Please look here carefully
	//______________________________________________
	//@OneToMany
	//@JoinColumn(name ="planid")
	//private Device device;
	
	//@OneToMany
	//@JoinColumn(name="deviceId")
	//private PhonePlan phoneplan;
	//________________________________________________
	
	
	
	public UserAccount() { }

	public UserAccount(int customerID, int planid, int deviceid, double monthlybill) {
		super();
		this.customerID = customerID;
		this.planid = planid;
		this.deviceid = deviceid;
		this.monthlybill = monthlybill;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		return "UserAccount [customerID=" + customerID + ", planid=" + planid + ", deviceid=" + deviceid
				+ ", monthlybill=" + monthlybill + "]";
	}
	
	

}
