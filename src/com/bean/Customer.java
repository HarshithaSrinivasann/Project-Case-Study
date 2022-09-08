package com.bean;

// import java.util.Date;

public class Customer {
	private String firstName;
	private String lastName;
	private String emailId;
	private int mobileNo;
	private String address1;
	private String address2;
	private String landmark;
	private int pincode;
	private String creationDate;
	private String operatorName;
	private String retailerName;
	
	
	public Customer(String firstName, String lastName, String emailId, int mobileNo, String address1, String address2,
			String landmark, int pincode,String creationDate,String operatorName, String retailerName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address1 = address1;
		this.address2 = address2;
		this.landmark = landmark;
		this.pincode = pincode;
		this.creationDate = creationDate;
		this.operatorName = operatorName;
		this.retailerName = retailerName;
	}
	
	public String getFName() {
		return firstName;
	}
	public void setFName(String firstName) {
		this.firstName = firstName;
	}
	public String getLName() {
		return lastName;
	}
	public void setLName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	
}


