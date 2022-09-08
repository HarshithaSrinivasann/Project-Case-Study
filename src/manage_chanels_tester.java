package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Manage_chanels;
import com.dao.Manage_chanels_dao;

public class manage_chanels_tester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testd12;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		Manage_chanels_dao e= new Manage_chanels_dao();
		Scanner sc = new Scanner(System.in);
		
		Manage_chanels_dao.createTable(connection);
		
		while(true)
		{
		  System.out.println("Menu");
		  System.out.println("1. Chanel Display \n2. Chanel insert\n3. Chanel delete \n4. Chanel update \n5. Add additonal package");
	
			 
		  switch(Integer.parseInt(sc.nextLine()))
			{
				case 1: 
					Manage_chanels_dao.displayRecords(connection);
				break;
				
				case 2: 
					System.out.print("Enter your Chanel_name: ");
					String chanel_name = sc.nextLine();
					System.out.print("\nEnter your Chanel_type: ");
					String chanel_type = sc.nextLine();
					System.out.print("\nEnter the video_freq: ");
					int v_freq_Mhz = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter the audio_freq: ");
					int a_freq_Mhz = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your charge_type: ");
					String charge_type = sc.nextLine();
					System.out.print("\nEnter your charge: ");
					int charge = Integer.parseInt(sc.nextLine());
					
					
					
					Manage_chanels e1= new Manage_chanels(chanel_name,chanel_type,v_freq_Mhz,a_freq_Mhz,charge_type,charge);
					System.out.println(Manage_chanels_dao.insertData(connection,e1));
					System.out.println("Registered successfully");
				
				break;
				
				case 3:
					System.out.print("Enter your chanel_name: ");
					chanel_name = sc.nextLine();
					Manage_chanels_dao.deleteData(connection, chanel_name);
				break;	
				case 4:
					
					System.out.print("\nEnter your chanel_name: ");
					String name= sc.nextLine();
					System.out.print("\nEnter your chanel_type: ");
					String type = sc.nextLine();
					System.out.print("\nEnter your v_freq_Mhz: ");
					int v_freq = Integer.parseInt(sc.nextLine());
					System.out.print("Enter your a_freq_Mhz: ");
					int a_freq = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter your charge_type: ");
					String charge_t = sc.nextLine();
					System.out.print("\nEnter your charge: ");
					int charge1 = Integer.parseInt(sc.nextLine());
					
					Manage_chanels_dao.updateData(connection,name,type,v_freq,a_freq,charge_t,charge1);
					break;
					
				case 5:
					System.out.println("Enter package you want to add \n1.Kids Pack- Rs225 \n2.General Pack- Rs 265 \n3.Sports Pack- Rs 300 \n4.Hd Pack- Rs 400 \n5.Regional Pack- Rs 200");
					String s=sc.nextLine();
					int res=Manage_chanels_dao.findPackage(s.toLowerCase());
					if(res==0)
						System.out.println("Package does not exist");
					else
						System.out.println("Default Package: Smart Package, Price: Rs 250");
						System.out.println("Additional Package: "+s+", Package charge: Rs"+res);
						int total=res+250;
						System.out.println("Total charge: Rs "+total);
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

