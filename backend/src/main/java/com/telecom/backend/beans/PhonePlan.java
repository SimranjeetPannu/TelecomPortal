package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plans")
public class PhonePlan {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "device_limit")
    private int deviceLimit;  
    
    @Column(name="price")
    private double price;

    @Column(name="user_id")
    private int userId;

    public PhonePlan() {};

    public PhonePlan(String planName, int deviceLimit, float price, int userId) {
        this.planName = planName;
        this.deviceLimit = deviceLimit;
        this.price = price;
        this.userId = userId;
    }

    public int getId() { 
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PhonePlan [deviceLimit=" + deviceLimit + ", id=" + id + ", planName=" + planName + ", price=" + price
                + ", userId=" + userId + "]";
    }
}