package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.STB;

public class STBDAO {

	
	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table STB (id int, stb_type varchar(10), feature varchar(100), heigth int, width int,length int, price int, icharge int, ucharge int, disc int, bill varchar(10), damt int, file varchar(50))";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
		
	public int insertData(Connection connection, STB e) throws SQLException
	{
		String sql = "insert into STB (id, stb_type,feature, heigth, width,length, price, icharge, ucharge, disc, bill, damt, file) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getStb_type());
		pstmt.setString(3, e.getFeature());
		pstmt.setInt(4, e.getHeight());
		pstmt.setInt(5, e.getWidth());
		pstmt.setInt(6, e.getLength());
		pstmt.setInt(7, e.getPrice());
		pstmt.setInt(8, e.getIcharge());
		pstmt.setInt(9, e.getUcharge());		
		pstmt.setInt(10, e.getDisc());
		pstmt.setString(11, e.getBill());
		pstmt.setInt(12, e.getDamt());
		pstmt.setString(13, e.getFile());		
		int rows=pstmt.executeUpdate();
		return rows;
	}
	
	public void displayRecords(Connection connection) throws SQLException
	{
		String sql = "select stb_type,feature, heigth, width,length, price, icharge, ucharge, disc, bill, damt, file from STB";
		Statement stmpt = connection.createStatement();
		
		ResultSet resultObj = stmpt.executeQuery(sql);
		
		while(resultObj.next())
		{
			System.out.println(String.format("Set top box type: %s", resultObj.getString("stb_type")));
			System.out.println(String.format("Feature: %s", resultObj.getString("feature")));
			System.out.println(String.format("Heigth: %d", resultObj.getInt("heigth")));
			System.out.println(String.format("Width: %d", resultObj.getInt("width")));
			System.out.println(String.format("Length: %d", resultObj.getInt("length")));
			System.out.println(String.format("Price: %d", resultObj.getInt("price")));
			System.out.println(String.format("Installation charge: %d", resultObj.getInt("icharge")));
			System.out.println(String.format("Upgradation charge: %d", resultObj.getInt("ucharge")));
			System.out.println(String.format("Discount: %d", resultObj.getInt("disc")));
			System.out.println(String.format("Bill type: %s", resultObj.getString("bill")));
			System.out.println(String.format("Inventory Details File: %s", resultObj.getString("file")));
		}
	}
	
	
	
	public int updateData(Connection connection,String stb_type, String feature, int height, int width, int length, int price, int icharge, int ucharge, int disc,
			String bill, int damt, String file,int id) throws SQLException
	{
		String sql="update STB set stb_type=?, feature=?, heigth=?, width=?,length=?, price=?, icharge=?, ucharge=?, disc=?, bill=?, damt=?, file=? where id=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,stb_type);
		ps.setString(2,feature);
		ps.setInt(3, height);
		ps.setInt(4, width);
		ps.setInt(5, length);
		ps.setInt(6, price);
		ps.setInt(7, icharge);
		ps.setInt(8, ucharge);
		ps.setInt(9, disc);
		ps.setString(10, bill);
		ps.setInt(11, damt);
		ps.setString(12, file);
		ps.setInt(13, id);
		int updated=ps.executeUpdate();
		return updated;
		
		
	}
	
	public void deleteData(Connection connection, int id) throws SQLException
	{
		String sql = "delete from STB where id = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	
	
}
