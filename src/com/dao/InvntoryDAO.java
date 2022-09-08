package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.bean Inventory;

public class InventoryDAO {
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select string Type,serial number,macid,Remote Control asset id,Dish asset id,Set TopBox Status from Inventory";
		Statement stmpt = connection.createStatement();
		
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("string Type: %d", resultObj.getInt("string Type")));
			System.out.println(String.format("serial number: %s", resultObj.getString("serial number")));
			System.out.println(String.format("macid: %d", resultObj.getInt("macid")));
			System.out.println(String.format("Remote Control assetid: %d", resultObj.getInt("Remote Control assetid")));
			System.out.println(String.format("Dish assetid: %d", resultObj.getString("Dish assetid")));
			System.out.println(String.format("Set TopBox Status: %s", resultObj.getString("Set TopBox Status")));
			}
	}
	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = (create table Inventory(string Type, number id, string macid, string Remote Control asset id ,string Dish asset id,string Set TopBox Status);
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int insertData(Connection connection, Inventory e) throws SQLException
	{
		String sql = "insert into Inventory (Type,serial number,macid,Remote Control assetid,dish assetid,Set TopBox Status) values (?,?,?,?,?,?,)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, e.getType());
		pstmt.setInt(2, e.getSerial number());
		pstmt.setString(3, e.getmacid());
		pstmt.setString(4, e.getRemote Control assetid());
		pstmt.setString(5, e.geDish assetidt());
		pstmt.setString(6, e.getSet TopBox Status());
		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public int updateData(Connection connection,String name,int ContactNo1,int ContactNo2,String Add1,String add2,int pinc,String city,String state,int STBL,double CL,double CP,double SC) throws SQLException
	{
		String sql="update Inventory string type=?,serial number=?,macid=?,Remote Control assetid=?,Dish assetidt=?,Set TopBox Status=?, city=?,where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,type);
		ps.setInt(2,serial number);
		ps.setString(3,macid);
		ps.setString(4,Remote Control assetid);
		ps.setString(5,Dish assetidt );
		ps.setString(6, Set TopBox Status);
		
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

	
