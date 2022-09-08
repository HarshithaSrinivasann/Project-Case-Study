package CustomerPurchase;

import CustomerPurchase.STB;
import CustomerPurchase.STBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CpDAO{
public void DisplayBySTBType(Connection connection, String StbType) throws SQLException
{
	String sql = "select feature, heigth, width,length, price, icharge, ucharge, disc, bill, damt, file from STB where stb_type = ?";
	
	PreparedStatement pstmt = connection.prepareStatement(sql);
	pstmt.setString(1,StbType);
	ResultSet resultObj = pstmt.executeQuery();
	
	while(resultObj.next())
	{
		System.out.println(String.format("Feature: %s", resultObj.getString("feature")));
		System.out.println(String.format("Heigth: %d", resultObj.getInt("heigth")));
		System.out.println(String.format("Width: %d", resultObj.getInt("width")));
		System.out.println(String.format("Length: %d", resultObj.getInt("length")));
		System.out.println(String.format("Price: %d", resultObj.getInt("price")));
		System.out.println(String.format("Installation charge: %d", resultObj.getInt("icharge")));
		System.out.println(String.format("Upgradation charge: %d", resultObj.getInt("ucharge")));
		System.out.println(String.format("Discount: %d", resultObj.getInt("disc")));
		System.out.println(String.format("Bill type: %d", resultObj.getString("bill")));
		System.out.println(String.format("Inventory Details File: %d", resultObj.getString("file")));
	}
}
public void Charging(Connection connection,String StbType , String name) throws SQLException {
String sql = "select feature, heigth, width,length, price, icharge, ucharge, disc, bill, damt, file from STB where stb_type = ?";
	
	PreparedStatement pstmt = connection.prepareStatement(sql);
	pstmt.setString(1,StbType);
	ResultSet resultObj = pstmt.executeQuery();
	
	while(resultObj.next())
	{
		System.out.println("Customer Name: "+name);
		System.out.println(String.format("Feature: %s", resultObj.getString("feature")));
		System.out.println(String.format("Heigth: %d", resultObj.getInt("heigth")));
		System.out.println(String.format("Width: %d", resultObj.getInt("width")));
		System.out.println(String.format("Length: %d", resultObj.getInt("length")));
		System.out.println(String.format("Price: %d", resultObj.getInt("price")));
		System.out.println(String.format("Installation charge: %d", resultObj.getInt("icharge")));
		System.out.println(String.format("Upgradation charge: %d", resultObj.getInt("ucharge")));
		System.out.println(String.format("Discount: %d", resultObj.getInt("disc")));
		System.out.println(String.format("Bill type: %d", resultObj.getString("bill")));
		System.out.println(String.format("Inventory Details File: %d", resultObj.getString("file")));
		
		int total = resultObj.getInt("price")+resultObj.getInt("icharge")+resultObj.getInt("ucharge")+resultObj.getInt("damt");
		total = total - (total*20)/100;
		System.out.println("Total Amount to Paid: "+total);
		
	}
}
}