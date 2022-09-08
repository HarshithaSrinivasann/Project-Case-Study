package com.bean;

public class Operator {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private int mobile;
	private double stime;
	//private double etime;
	private int max_cust;
	
	
	public Operator(int id, String fname, String lname, String email, int mobile, double stime, int max_cust) {
		
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.stime = stime;
		this.max_cust = max_cust;
		
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public double getStime() {
		return stime;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setStime(double stime) {
		this.stime = stime;
	}


	public int getMax_cust() {
		return max_cust;
	}


	public void setMax_cust(int max_cust) {
		this.max_cust = max_cust;
	}
	
	
	

}
