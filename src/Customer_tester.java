package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


//import com.bean.Employee;
import com.bean.Customer;
import com.dao.Customer_dao;

public class Customer_tester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testdb4;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		Customer_dao dao=new Customer_dao();
		Scanner sc = new Scanner(System.in);
		
		dao.createTable(connection);
		
		//while(true)
		//{
			//System.out.println("Menu");
			//System.out.println("1. Customer Management \n2. Operator Management\n3. Retailer Management");
			
			
			System.out.print("Enter your First name: ");
			String fname = sc.nextLine();
			System.out.print("\nEnter your Last name: ");
			String lname = sc.nextLine();
			System.out.print("\nEnter your Email ID: ");
			String email = sc.nextLine();
			System.out.print("\nEnter your Phone number: ");
			int mobile = Integer.parseInt(sc.nextLine());
			sc.nextLine();
			System.out.print("\nEnter your Add1: ");
			String address1 = sc.nextLine();
			System.out.print("\nEnter your Add2: ");
			String address2 = sc.nextLine();
			System.out.print("\nEnter your landmark: ");
			String landmark = sc.nextLine();
			System.out.print("\nEnter your pincode: ");
			int pincode = Integer.parseInt(sc.nextLine());
			sc.nextLine();
			System.out.print("\nEnter your create date: ");
			String creationDate = sc.nextLine();
			System.out.print("Enter your Operator name: ");
			String operator = sc.nextLine();
			System.out.print("Enter your Retailer name: ");
			String retailer = sc.nextLine();
			
			
			
			Customer e1=new Customer(fname, lname,email,mobile,address1,address2,landmark,pincode,creationDate,operator,retailer);
			System.out.println(dao.insertData(connection,e1));
			System.out.println("Registered successfully");
		
	
			 
			/*switch(Integer.parseInt(sc.nextLine()))
			{
				case 1: 
					dao.displayRecords(connection);
				break;
				
				case 2: 
					System.out.print("Enter your ID: ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Name: ");
					String name = sc.nextLine();
					System.out.print("\nEnter your Age: ");
					int age = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Salary: ");
					int salary = Integer.parseInt(sc.nextLine());
					Operator e1=new Operator(id,name,age,salary);
					System.out.println(dao.insertData(connection,e1));
				break;
				
				case 3:
					System.out.print("Enter your ID: ");
					id = Integer.parseInt(sc.nextLine());
					dao.deleteData(connection, id);
				break;	
				case 4:
					
					System.out.print("\nEnter your Name: ");
					String n= sc.nextLine();
					System.out.print("\nEnter your Age: ");
					int a = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your Salary: ");
					int sal = Integer.parseInt(sc.nextLine());
					System.out.print("Enter your ID: ");
					int eid = Integer.parseInt(sc.nextLine());
					
					dao.updateData(connection,n,a,sal,eid);
					break;
					
				
					
			}
			
			System.out.println("Press e to exit!");
			if(sc.nextLine().equals("e"))
			{
				break;
			}
		}*/
		
		connection.close();
	}

	}
