package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Operator;
import com.dao.OperatorDAO;

public class OperatorTester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testdb2;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		OperatorDAO dao=new OperatorDAO();
		Scanner sc = new Scanner(System.in);
		
		//dao.createTable(connection);
		
		//while(true)
		//{
			//System.out.println("Menu");
			//System.out.println("1. Customer Management \n2. Operator Management\n3. Retailer Management");
			
		while(true)
		{
			System.out.println("Menu");
			System.out.println("1. Display\n2. Insert\n3. Delete\n4. Update");
			
			switch(Integer.parseInt(sc.nextLine()))
			{
				case 1: 
					dao.displayRecords(connection);
				break;
				
				case 2:
					System.out.print("\nEnter your ID: ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter your First name: ");
					String fname = sc.nextLine();
					System.out.print("\nEnter your Last name: ");
					String lname = sc.nextLine();
					System.out.print("\nEnter your Email ID: ");
					String email = sc.nextLine();
					System.out.print("\nEnter your Phone number: ");
					int mobile = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Shift Start time: ");
					double stime = Double.parseDouble(sc.nextLine());
					System.out.print("\nEnter your Max no of customer to be managed: ");
					int max_cust = Integer.parseInt(sc.nextLine());
					
					Operator e1=new Operator(id,fname,lname,email,mobile,stime,max_cust);
					System.out.println(dao.insertData(connection,e1));
					System.out.println("Registered successfully");
				break;
					
				case 3:
					System.out.print("Enter your ID: ");
					id = Integer.parseInt(sc.nextLine());
					dao.deleteData(connection, id);
				break;	
				case 4:
					
					System.out.print("Enter your First name: ");
					String fn = sc.nextLine();
					System.out.print("\nEnter your Last name: ");
					String ln = sc.nextLine();
					System.out.print("\nEnter your Email ID: ");
					String e = sc.nextLine();
					System.out.print("\nEnter your Phone number: ");
					int m = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Shift Start time: ");
					double st = Double.parseDouble(sc.nextLine());
					System.out.print("\nEnter your Max no of customer to be managed: ");
					int mc = Integer.parseInt(sc.nextLine());
					System.out.print("Enter your ID: ");
					int eid = Integer.parseInt(sc.nextLine());
					
					dao.updateData(connection,fn,ln,e,m,st,mc,eid);
					break;
					
				
					
			}
			
			System.out.println("Press e to exit!");
			if(sc.nextLine().equals("e"))
			{
				break;
			}
		}
		
		
		connection.close();
	}

	}





		
	


