package com.ezwallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer customerId;	
	
	@Size(max = 10, message = "Enter valid mobile number")
	private String mobileNumber;
	
	@NotNull(message = "Please Enter the valid name")
	@Size(min = 3, message = "Please Enter the valid name")
	private String name;
	
	@NotNull
	@Size(min = 6, max = 8, message = "Password should contain  6 to 8 characters")
	private String password;		
	
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public Integer getCustomerId() {
//		return customerId;
//	}
//
//
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}
//
//
//	
//	
	
}
