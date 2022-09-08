package com.bean;

public class Manage_chanels {
    
	private String chanel_name;
	private String chanel_band;
	private int v_freq_Mhz;
	private int a_freq_Mhz;
	private String charge_type;
	private int charge;
	
	public Manage_chanels(String chanel_name, String chanel_band, int v_freq_Mhz, int a_freq_Mhz, String charge_type,
			int charge) {
		super();
		this.chanel_name = chanel_name;
		this.chanel_band = chanel_band;
		this.v_freq_Mhz = v_freq_Mhz;
		this.a_freq_Mhz = a_freq_Mhz;
		this.charge_type = charge_type;
		this.charge = charge;
	}
	
	
	public String getChanel_name() {
		return chanel_name;
	}
	public void setChanel_name(String chanel_name) {
		this.chanel_name = chanel_name;
	}
	public String getChanel_band() {
		return chanel_band;
	}
	public void setChanel_band(String chanel_band) {
		this.chanel_band = chanel_band;
	}
	public int getV_freq_Mhz() {
		return v_freq_Mhz;
	}
	public void setV_freq_Mhz(int v_freq_Mhz) {
		this.v_freq_Mhz = v_freq_Mhz;
	}
	public int getA_freq_Mhz() {
		return a_freq_Mhz;
	}
	public void setA_freq_Mhz(int a_freq_Mhz) {
		this.a_freq_Mhz = a_freq_Mhz;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	
}
