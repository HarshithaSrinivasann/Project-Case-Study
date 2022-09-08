package com.dao;




import java.sql.*;
import java.util.HashMap;

import com.bean.Manage_chanels;

public class Manage_chanels_dao {
	static  HashMap<String, Integer> map = new HashMap<>();
	
	public static void createTable(Connection connection) throws SQLException
	{
		
		/* String sql2 = "create table Manage_chanels (chanel_name varchar(30),chanel_band varchar(20),v_freq_Mhz int,a_freq_Mhz int,charge_type varchar(20),charge int)";
		Statement stmt = connection.createStatement();
		stmt.execute(sql2); */
		
		String sql = "create table Manage_chanels (chanel_name varchar(30),chanel_type varchar(30),v_freq_Mhz int,a_freq_Mhz int,charge_type varchar(20),charge int)";
		Statement stmt = connection.createStatement();
		stmt.execute(sql);
		
	}
	
	
	public static void displayRecords(Connection connection) throws SQLException
	{
		String sql2 = "select chanel_name,chanel_type,v_freq_Mhz,a_freq_Mhz,charge_type,charge from Manage_chanels";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql2);
		
		while(resultObj.next())
		{
			System.out.println(String.format("chanel_name: %s", resultObj.getString("chanel_name")));
			System.out.println(String.format("chanel_type: %s", resultObj.getString("chanel_type")));
			System.out.println(String.format("v_freq_Mhz: %d", resultObj.getInt("v_freq_Mhz")));
			System.out.println(String.format("a_freq_Mhz: %d", resultObj.getInt("a_freq_Mhz")));
			System.out.println(String.format("charge_type: %s", resultObj.getString("charge_type")));
			System.out.println(String.format("charge: %d", resultObj.getInt("charge")));

			
		}
	}
	
	public static int insertData(Connection connection, Manage_chanels e) throws SQLException
	{
		String sql2 = "insert into Manage_chanels (chanel_name,chanel_type,v_freq_Mhz,a_freq_Mhz,charge_type,charge) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql2);
		pstmt.setString(1, e.getChanel_name());
		pstmt.setString(2, e.getChanel_band());
		pstmt.setInt(3, e.getV_freq_Mhz());
		pstmt.setInt(4, e.getA_freq_Mhz());
		pstmt.setString(5, e.getCharge_type());
		pstmt.setInt(6, e.getCharge());
		
		int rows1=pstmt.executeUpdate();
		return rows1;
	}
	
	public static int updateData(Connection connection,String chanel_name,String chanel_type,int v_freq_Mhz,int a_freq_Mhz,String charge_type,int charge) throws SQLException
	{
		String sql2="update Manage_chanels set chanel_type=?,v_freq_Mhz=?,a_freq_Mhz=?,charge_type=?,charge=? where chanel_name = ?";
		PreparedStatement ps=connection.prepareStatement(sql2);
		ps.setString(1,chanel_name);
		ps.setString(2,chanel_type);
		ps.setInt(3, v_freq_Mhz);
		ps.setInt(4, a_freq_Mhz);
		ps.setString(5, charge_type);
		ps.setInt(6, charge);
		
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public static void deleteData(Connection connection, String chanel_name) throws SQLException
	{
		String sql2 = "delete from Manage_chanels where chanel_name = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql2);
		pstmt.setString(1, chanel_name);
		pstmt.execute();
	}
	public static int findPackage(String s)
	{
		 map.put("smart pack", 250);
	     map.put("kids pack", 255);
	     map.put("general pack", 265);
	     map.put("sports pack", 300);
	     map.put("hd pack", 400);
	     map.put("regional pack", 200);
		if(map.containsKey(s))
			return map.get(s);
		return 0;
			
	}


}

