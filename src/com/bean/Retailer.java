package com.bean;

import java.time.LocalDate;

public class Retailer {
		private int id;
		private String name;
		private int ContactNo1;
		private int ContactNo2;
		private String Add1;
		private String add2;
		private int pinc;
		private String city;
		private String state;
		private int STBL;
		private double CL;
		private double CP;
		private double SC;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCN1() {
			return ContactNo1;
		}
		public void setCN1(int ContactNo1) {
			this.ContactNo1 = ContactNo1;
		}
		public int getCN2() {
			return ContactNo2;
		}
		public void setCN2(int ContactNo2) {
			this.ContactNo2 = ContactNo2;
		}
		public String getAdd1() {
			return Add1;
		}
		public void setAdd1(String Add1) {
			this.Add1 = Add1;
		}
		public String getAdd2() {
			return add2;
		}
		public void setAdd2(String add2) {
			this.add2 = add2;
		}
		public String getcity() {
			return city;
		}
		public void setcity(String city) {
			this.city = city;
		}
		public String getstate() {
			return state;
		}
		public void setstate(String state) {
			this.state = state;
		}
		public int getpinc() {
			return pinc;
		}
		public void setpinc(int pinc) {
			this.pinc = pinc;
		}
		public int getSTBL() {
			return STBL;
		}
		public void setSTBL(int STBL) {
			this.STBL = STBL;
		}
		public double getCL() {
			return CL;
		}
		public void setCL(double CL) {
			this.CL = CL;
		}
		public double getCP() {
			return CP;
		}
		public void setCP(double CP) {
			this.CP = CP;
		}
		public double getSC() {
			return SC;
		}
		public void setSC(double SC) {
			this.SC = SC;
		}
		
		public Retailer(int id, String name,int ContactNo1,int ContactNo2,String Add1,String add2,int pinc,String city,String state,int STBL,double CL,double CP,double SC){
			this.id=id;
			this.name=name;
			this.ContactNo1=ContactNo1;
			this.ContactNo2=ContactNo2;
			this.Add1=Add1;
			this.add2=add2;
			this.pinc=pinc;
			this.city=city;
			this.state=state;
			this.STBL=STBL;
			this.CL=CL;
			this.CP=CP;
			this.SC=SC;
			
	}

