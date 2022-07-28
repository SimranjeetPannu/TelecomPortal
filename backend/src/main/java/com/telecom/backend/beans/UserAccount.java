package com.telecom.backend.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccounts")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;

	@Column(name = "customerid")
	private int customerId;

	@Column(name = "monthlybill")
	private double monthlybill;

	@Column(name = "phoneplan1")
	private String phonePlan1;

	@Column(name = "phoneplan1cost")
	private double phonePlan1Cost;

	@Column(name = "phoneplan2")
	private String phonePlan2;

	@Column(name = "phoneplan2cost")
	private double phonePlan2Cost;

	@Column(name = "phoneplan3")
	private String phonePlan3;

	@Column(name = "phoneplan3cost")
	private double phonePlan3Cost;

	@Column(name = "phoneplan4")
	private String phonePlan4;

	@Column(name = "phoneplan4cost")
	private double phonePlan4Cost;

	@Column(name = "phoneplan5")
	private String phonePlan5;

	@Column(name = "phoneplan5cost")
	private double phonePlan5Cost;

	@Column(name = "device1")
	private String device1;

	@Column(name = "device1cost")
	private double device1Cost;

	@Column(name = "device2")
	private String device2;

	@Column(name = "device2cost")
	private double device2Cost;

	@Column(name = "device3")
	private String device3;

	@Column(name = "device3cost")
	private double device3Cost;

	@Column(name = "device4")
	private String device4;

	@Column(name = "device4cost")
	private double device4Cost;

	@Column(name = "device5")
	private String device5;

	@Column(name = "device5cost")
	private double device5Cost;

	@Column(name = "device6")
	private String device6;

	@Column(name = "device6cost")
	private double device6Cost;

	@Column(name = "device7")
	private String device7;

	@Column(name = "device7cost")
	private double device7Cost;

	@Column(name = "device8")
	private String device8;

	@Column(name = "device8cost")
	private double device8Cost;

	@Column(name = "device9")
	private String device9;

	@Column(name = "device9cost")
	private double device9Cost;

	@Column(name = "device10")
	private String device10;

	@Column(name = "device10cost")
	private double device10Cost;

	public UserAccount() {
	}

	public UserAccount(String username, int customerId, double monthlybill, String phonePlan1, double phonePlan1Cost,
			String phonePlan2, double phonePlan2Cost, String phonePlan3, double phonePlan3Cost, String phonePlan4,
			double phonePlan4Cost, String phonePlan5, double phonePlan5Cost, String device1, double device1Cost,
			String device2, double device2Cost, String device3, double device3Cost, String device4, double device4Cost,
			String device5, double device5Cost, String device6, double device6Cost, String device7, double device7Cost,
			String device8, double device8Cost, String device9, double device9Cost, String device10,
			double device10Cost) {
		this.username = username;
		this.customerId = customerId;
		this.monthlybill = monthlybill;
		this.phonePlan1 = phonePlan1;
		this.phonePlan1Cost = phonePlan1Cost;
		this.phonePlan2 = phonePlan2;
		this.phonePlan2Cost = phonePlan2Cost;
		this.phonePlan3 = phonePlan3;
		this.phonePlan3Cost = phonePlan3Cost;
		this.phonePlan4 = phonePlan4;
		this.phonePlan4Cost = phonePlan4Cost;
		this.phonePlan5 = phonePlan5;
		this.phonePlan5Cost = phonePlan5Cost;
		this.device1 = device1;
		this.device1Cost = device1Cost;
		this.device2 = device2;
		this.device2Cost = device2Cost;
		this.device3 = device3;
		this.device3Cost = device3Cost;
		this.device4 = device4;
		this.device4Cost = device4Cost;
		this.device5 = device5;
		this.device5Cost = device5Cost;
		this.device6 = device6;
		this.device6Cost = device6Cost;
		this.device7 = device7;
		this.device7Cost = device7Cost;
		this.device8 = device8;
		this.device8Cost = device8Cost;
		this.device9 = device9;
		this.device9Cost = device9Cost;
		this.device10 = device10;
		this.device10Cost = device10Cost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getMonthlybill() {
		return monthlybill;
	}

	public void setMonthlybill(double monthlybill) {
		this.monthlybill = monthlybill;
	}

	public String getPhonePlan1() {
		return phonePlan1;
	}

	public void setPhonePlan1(String phonePlan1) {
		this.phonePlan1 = phonePlan1;
	}

	public double getPhonePlan1Cost() {
		return phonePlan1Cost;
	}

	public void setPhonePlan1Cost(double phonePlan1Cost) {
		this.phonePlan1Cost = phonePlan1Cost;
	}

	public String getPhonePlan2() {
		return phonePlan2;
	}

	public void setPhonePlan2(String phonePlan2) {
		this.phonePlan2 = phonePlan2;
	}

	public double getPhonePlan2Cost() {
		return phonePlan2Cost;
	}

	public void setPhonePlan2Cost(double phonePlan2Cost) {
		this.phonePlan2Cost = phonePlan2Cost;
	}

	public String getPhonePlan3() {
		return phonePlan3;
	}

	public void setPhonePlan3(String phonePlan3) {
		this.phonePlan3 = phonePlan3;
	}

	public double getPhonePlan3Cost() {
		return phonePlan3Cost;
	}

	public void setPhonePlan3Cost(double phonePlan3Cost) {
		this.phonePlan3Cost = phonePlan3Cost;
	}

	public String getPhonePlan4() {
		return phonePlan4;
	}

	public void setPhonePlan4(String phonePlan4) {
		this.phonePlan4 = phonePlan4;
	}

	public double getPhonePlan4Cost() {
		return phonePlan4Cost;
	}

	public void setPhonePlan4Cost(double phonePlan4Cost) {
		this.phonePlan4Cost = phonePlan4Cost;
	}

	public String getPhonePlan5() {
		return phonePlan5;
	}

	public void setPhonePlan5(String phonePlan5) {
		this.phonePlan5 = phonePlan5;
	}

	public double getPhonePlan5Cost() {
		return phonePlan5Cost;
	}

	public void setPhonePlan5Cost(double phonePlan5Cost) {
		this.phonePlan5Cost = phonePlan5Cost;
	}

	public String getDevice1() {
		return device1;
	}

	public void setDevice1(String device1) {
		this.device1 = device1;
	}

	public double getDevice1Cost() {
		return device1Cost;
	}

	public void setDevice1Cost(double device1Cost) {
		this.device1Cost = device1Cost;
	}

	public String getDevice2() {
		return device2;
	}

	public void setDevice2(String device2) {
		this.device2 = device2;
	}

	public double getDevice2Cost() {
		return device2Cost;
	}

	public void setDevice2Cost(double device2Cost) {
		this.device2Cost = device2Cost;
	}

	public String getDevice3() {
		return device3;
	}

	public void setDevice3(String device3) {
		this.device3 = device3;
	}

	public double getDevice3Cost() {
		return device3Cost;
	}

	public void setDevice3Cost(double device3Cost) {
		this.device3Cost = device3Cost;
	}

	public String getDevice4() {
		return device4;
	}

	public void setDevice4(String device4) {
		this.device4 = device4;
	}

	public double getDevice4Cost() {
		return device4Cost;
	}

	public void setDevice4Cost(double device4Cost) {
		this.device4Cost = device4Cost;
	}

	public String getDevice5() {
		return device5;
	}

	public void setDevice5(String device5) {
		this.device5 = device5;
	}

	public double getDevice5Cost() {
		return device5Cost;
	}

	public void setDevice5Cost(double device5Cost) {
		this.device5Cost = device5Cost;
	}

	public String getDevice6() {
		return device6;
	}

	public void setDevice6(String device6) {
		this.device6 = device6;
	}

	public double getDevice6Cost() {
		return device6Cost;
	}

	public void setDevice6Cost(double device6Cost) {
		this.device6Cost = device6Cost;
	}

	public String getDevice7() {
		return device7;
	}

	public void setDevice7(String device7) {
		this.device7 = device7;
	}

	public double getDevice7Cost() {
		return device7Cost;
	}

	public void setDevice7Cost(double device7Cost) {
		this.device7Cost = device7Cost;
	}

	public String getDevice8() {
		return device8;
	}

	public void setDevice8(String device8) {
		this.device8 = device8;
	}

	public double getDevice8Cost() {
		return device8Cost;
	}

	public void setDevice8Cost(double device8Cost) {
		this.device8Cost = device8Cost;
	}

	public String getDevice9() {
		return device9;
	}

	public void setDevice9(String device9) {
		this.device9 = device9;
	}

	public double getDevice9Cost() {
		return device9Cost;
	}

	public void setDevice9Cost(double device9Cost) {
		this.device9Cost = device9Cost;
	}

	public String getDevice10() {
		return device10;
	}

	public void setDevice10(String device10) {
		this.device10 = device10;
	}

	public double getDevice10Cost() {
		return device10Cost;
	}

	public void setDevice10Cost(double device10Cost) {
		this.device10Cost = device10Cost;
	}

	@Override
	public String toString() {
		return "UserAccount [customerId=" + customerId + ", device1=" + device1 + ", device10=" + device10
				+ ", device10Cost=" + device10Cost + ", device1Cost=" + device1Cost + ", device2=" + device2
				+ ", device2Cost=" + device2Cost + ", device3=" + device3 + ", device3Cost=" + device3Cost
				+ ", device4=" + device4 + ", device4Cost=" + device4Cost + ", device5=" + device5 + ", device5Cost="
				+ device5Cost + ", device6=" + device6 + ", device6Cost=" + device6Cost + ", device7=" + device7
				+ ", device7Cost=" + device7Cost + ", device8=" + device8 + ", device8Cost=" + device8Cost
				+ ", device9=" + device9 + ", device9Cost=" + device9Cost + ", monthlybill=" + monthlybill
				+ ", phonePlan1=" + phonePlan1 + ", phonePlan1Cost=" + phonePlan1Cost + ", phonePlan2=" + phonePlan2
				+ ", phonePlan2Cost=" + phonePlan2Cost + ", phonePlan3=" + phonePlan3 + ", phonePlan3Cost="
				+ phonePlan3Cost + ", phonePlan4=" + phonePlan4 + ", phonePlan4Cost=" + phonePlan4Cost + ", phonePlan5="
				+ phonePlan5 + ", phonePlan5Cost=" + phonePlan5Cost + ", username=" + username + "]";
	}

	
	
}