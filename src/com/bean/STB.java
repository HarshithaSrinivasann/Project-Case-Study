package com.bean;

public class STB {

	
	private int id;
	private String stb_type;
	private String feature;
	private int height;
	private int width;
	private int length;
	private int price;
	private int icharge;
	private int ucharge;
	private int disc;
	private String bill;
	private int damt;
	private String file;
	

	public STB(int id, String stb_type, String feature, int height, int width, int length, int price, int icharge, int ucharge, int disc,
			String bill, int damt, String file) {
		this.id=id;
		this.stb_type = stb_type;
		this.feature = feature;
		this.height = height;
		this.width = width;
		this.length = length;
		this.price = price;
		this.icharge = icharge;
		this.ucharge = ucharge;
		this.disc = disc;
		this.bill = bill;
		this.damt = damt;
		this.file = file;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFeature() {
		return feature;
	}


	public void setFeature(String feature) {
		this.feature = feature;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getIcharge() {
		return icharge;
	}


	public void setIcharge(int icharge) {
		this.icharge = icharge;
	}


	public int getUcharge() {
		return ucharge;
	}


	public void setUcharge(int ucharge) {
		this.ucharge = ucharge;
	}


	public int getDisc() {
		return disc;
	}


	public void setDisc(int disc) {
		this.disc = disc;
	}


	public String getBill() {
		return bill;
	}


	public void setBill(String bill) {
		this.bill = bill;
	}


	public int getDamt() {
		return damt;
	}


	public void setDamt(int damt) {
		this.damt = damt;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getStb_type() {
		return stb_type;
	}


	public void setStb_type(String stb_type) {
		this.stb_type = stb_type;
	}
	
	

	
}
