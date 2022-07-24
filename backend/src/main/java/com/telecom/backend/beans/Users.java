package com.telecom.backend.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    
    @Column
    private String username;
    @Column
    private String password;
    public Users() {
    }
    
    
	public Users(int customerID, String username, String password) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
	}


	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Users [customerID=" + customerID + ", username=" + username + ", password=" + password + "]";
	}
   
   
}
