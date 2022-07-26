package com.telecom.backend.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numbers")
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phonenumber")
    private int phoneNumber;
    @Column(name = "deviceid")
    private int deviceId;

    public Numbers() {

    }

    public Numbers(int phoneNumber, int deviceId) {
        this.phoneNumber = phoneNumber;
        this.deviceId = deviceId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Numbers [deviceId=" + deviceId + ", phoneNumber=" + phoneNumber + "]";
    }
 
}

