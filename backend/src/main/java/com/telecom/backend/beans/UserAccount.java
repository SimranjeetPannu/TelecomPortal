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
@Table(name = "useraccount")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@OneToOne                 //need to verify this with team
	//@JoinColumn(name="customerID")
	private int customerID;
	
	@Column
	private int planid;
	
	@Column
	private int deviceid;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
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

	public UserAccount(int customerID, int planid, int deviceid, String firstname, String lastname,
			double monthlybill) {
		super();
		this.customerID = customerID;
		this.planid = planid;
		this.deviceid = deviceid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.monthlybill = monthlybill;
	}
	
	@Override
	public String toString() {
		return "UserAccount [customerID=" + customerID + ", planid=" + planid + ", deviceid=" + deviceid
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", monthlybill=" + monthlybill + "]";
	}
	
	

}
