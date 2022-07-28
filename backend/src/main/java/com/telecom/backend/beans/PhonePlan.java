package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "plan")
public class PhonePlan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planid;
    
    @Column(name = "planname")
    private String planName;
    
    @Column(name = "plancost")
    private int planCost;
    
    @Column(name = "devicelimit")
    private int deviceLimit;

	@ManyToOne
	@JoinColumn(name = "customerid")
	private PhonePlan plan;

    public PhonePlan() {

    }

	
	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getPlanCost() {
		return planCost;
	}

	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}

	public int getDeviceLimit() {
		return deviceLimit;
	}

	public void setDeviceLimit(int deviceLimit) {
		this.deviceLimit = deviceLimit;
	}
	
	@Override
	public String toString() {
		return "phoneplan [planid=" + planid + ", planName=" + planName + ", planCost=" + planCost + ", deviceLimit="
				+ deviceLimit + "]";
	}

}
