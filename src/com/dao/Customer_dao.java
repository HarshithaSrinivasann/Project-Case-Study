package com.dao;

import java.sql.*;
import java.util.*;

//import com.bean.Employee;
import com.bean.Customer;

public class Customer_dao {
	
	public void createTable(Connection connection) throws SQLException
	{
		
		String sql1 = "create table Customer (fname varchar(30), lname varchar(30), email varchar(30), mobile int,address1 varchar(30),address2 varchar(30),landmark varchar(30),pincode int,creationDate varchar(20),operator varchar(30),retailer varchar(30))";
		Statement stmt1 = connection.createStatement();
		stmt1.execute(sql1);
		
		/* String sql = "create table Customer (fname varchar(30), lname varchar(30), email varchar(30), mobile int,address1 varchar(30),address2 varchar(30),landmark varchar(30),pincode int,creationDate varchar(20),operator varchar(30),retailer varchar(30)";
		Statement stmt = connection.createStatement();
		stmt.execute(sql); */
	}
	
	public int insertData(Connection connection, Customer e) throws SQLException
	{
		String sql = "insert into Customer (fname, lname,email,mobile,address1,address2,landmark,pincode,creationDate,operator,retailer) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, e.getFName());
		pstmt.setString(2, e.getLName());
		pstmt.setString(3, e.getEmailId());
		pstmt.setInt(4, e.getMobileNo());
		pstmt.setString(5, e.getAddress1());
		pstmt.setString(6, e.getAddress2());
		pstmt.setString(7, e.getLandmark());
		pstmt.setInt(8, e.getPincode());
		pstmt.setString(9, e.getCreationDate());
		pstmt.setString(10, e.getOperatorName());
		pstmt.setString(11, e.getRetailerName());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	/*public int updateData(Connection connection,String name,int age,int sal,int id) throws SQLException
	{
		String sql="update Employee set name=?,age=?,salary=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2,age);
		ps.setInt(3, sal);
		ps.setInt(4, id);
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
	*/

}