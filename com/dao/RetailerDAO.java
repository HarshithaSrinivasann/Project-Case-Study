package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.bean.Retailer;

public class RetailerDAO {
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select id, name, ContactNo1, ContactNo2, Add1, add2, pinc, city, state, STBL, CL, CP, SC from Retailer";
		Statement stmpt = connection.createStatement();
		
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("ID: %d", resultObj.getInt("id")));
			System.out.println(String.format("Name: %s", resultObj.getString("name")));
			System.out.println(String.format("Contact no 1: %d", resultObj.getInt("ContactNo1")));
			System.out.println(String.format("Contact no 2: %d", resultObj.getInt("ContactNo2")));
			System.out.println(String.format("Address Line 1: %d", resultObj.getString("Add1")));
			System.out.println(String.format("Address Line 2: %s", resultObj.getString("add2")));
			System.out.println(String.format("Pincode: %d", resultObj.getInt("pinc")));
			System.out.println(String.format("City: %d", resultObj.getString("city")));
			System.out.println(String.format("State: %d", resultObj.getString("state")));
			System.out.println(String.format("Set Top Box Limit: %s", resultObj.getInt("STBL")));
			System.out.println(String.format("Credit Limit: %d", resultObj.getDouble("CL")));
			System.out.println(String.format("Commission Percentage: %d", resultObj.getDouble("CP")));
			System.out.println(String.format("Service Charges: %d", resultObj.getDouble("SC")));
		}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Retailer (id int, name varchar(30), ContactNo1 int, ContactNo2 int, Add1 varchar(30), add2 varchar(30), pinc int, city varchar(20), state varchar(20), STBL int, CL double, CP double, SC double)";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Retailer e) throws SQLException
	{
		String sql = "insert into Retailer (id, name, contactNo1, ContactNo2, Add1, add2, pinc, city, state, STBL,CL, CP,SC) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getCN1());
		pstmt.setInt(4, e.getCN2());
		pstmt.setString(5, e.getAdd1());
		pstmt.setString(6, e.getAdd2());
		pstmt.setString(7, e.getcity());
		pstmt.setString(8, e.getstate());
		pstmt.setInt(9, e.getpinc());
		pstmt.setInt(10, e.getSTBL());
		pstmt.setDouble(11, e.getCL());
		pstmt.setDouble(12, e.getCP());
		
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,int ContactNo1,int ContactNo2,String Add1,String add2,int pinc,String city,String state,int STBL,double CL,double CP,double SC) throws SQLException
	{
		String sql="update Retailer set name=?,ContactNo1=?,contactNo2=?, Add1=?, add2=?, pinc=?, city=?, state=?, STBL=?,CL=?, CP=?,SC=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2,ContactNo1);
		ps.setInt(3, ContactNo2);
		ps.setString(4, Add1);
		ps.setString(5, add2);
		ps.setInt(6, pinc);
		ps.setString(7,city);
		ps.setString(8, state);
		ps.setInt(9, STBL);
		ps.setDouble(10, CL);
		ps.setDouble(11, CP);
		ps.setDouble(12, SC);
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from Employee where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	

}

	
