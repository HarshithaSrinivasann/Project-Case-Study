package com.dao;


	import java.sql.*;
	import java.util.*;

import com.bean.Operator;

	public class OperatorDAO {
		
		public void createTable(Connection connection) throws SQLException
		{
			String sql = "create table Operator2 (id int,fname varchar(30), lname varchar(30), email varchar(30), mobile int, stime double, etime double, maxcust int)";
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
		}
		
		public int insertData(Connection connection, Operator e) throws SQLException
		{
			String sql = "insert into Operator2 (id,fname, lname, email, mobile, stime, etime, maxcust) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getFname());
			pstmt.setString(3, e.getLname());
			pstmt.setString(4, e.getEmail());
			pstmt.setInt(5, e.getMobile());
			pstmt.setDouble(6, e.getStime());
			pstmt.setDouble(7, e.getStime()+8);
			pstmt.setInt(8, e.getMax_cust());
			
			int rows=pstmt.executeUpdate();
			return rows;
		}
		
		public void displayRecords(Connection connection) throws SQLException
		{
			String sql = "select fname, lname, email, mobile, stime, etime, maxcust from Operator2";
			Statement stmpt = connection.createStatement();
			
			ResultSet resultObj = stmpt.executeQuery(sql);
			
			while(resultObj.next())
			{
				System.out.println(String.format("First Name: %s", resultObj.getString("fname")));
				System.out.println(String.format("Last Name: %s", resultObj.getString("lname")));
				System.out.println(String.format("Email ID: %s", resultObj.getString("email")));
				System.out.println(String.format("Phone number: %d", resultObj.getInt("mobile")));
				System.out.println(String.format("Start time: %f", resultObj.getDouble("stime")));
				System.out.println(String.format("End time: %f", resultObj.getDouble("etime")));
				System.out.println(String.format("Max no of customers: %d", resultObj.getInt("maxcust")));
			}
		}
		
		
		public int updateData(Connection connection, String fname, String lname, String email, int mobile, double stime, int max_cust,int id) throws SQLException
		{
			String sql="update Operator2 set fname=?, lname=?, email=?, mobile=?, stime=?, etime=?, maxcust=? where id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,email);
			ps.setInt(4,mobile);
			ps.setDouble(5, stime);
			ps.setDouble(6, (stime+8));
			ps.setInt(7,max_cust);
			ps.setInt(8,id);
			int updated=ps.executeUpdate();
			return updated;
			
			
		}
		
		public void deleteData(Connection connection, int id) throws SQLException
		{
			String sql = "delete from Operator2 where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		}

	}
	

