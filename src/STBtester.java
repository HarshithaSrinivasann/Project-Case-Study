package com.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.STB;
import com.dao.STBDAO;

public class STBtester {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:derby:testdb3;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		STBDAO dao=new STBDAO();
		Scanner sc = new Scanner(System.in);
		
		//dao.createTable(connection);
		
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
					System.out.print("Enter your ID: ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.print("\nChoose your Set top box type from below: \nStandard \nHD \nHD+ \nIPTV\n");
					String stb_type = sc.nextLine();
					System.out.print("\nChoose features from below: \nLive recording \nScheduled recording \nPause and play\n");
					String feature = sc.nextLine();
					System.out.print("Enter Height: ");
					int height = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Width: ");
					int width = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Length: ");
					int length = Integer.parseInt(sc.nextLine());
					System.out.print("Enter price: ");
					int price = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Installation charge: ");
					int icharge = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Upgradation charge: ");
					int ucharge = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter Discount (in %): ");
					int disc = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Billing type: \n1.Prepaid \n2.Postpaid");
					String bill = sc.nextLine();
					int damt =0;
					if(bill.equalsIgnoreCase("postpaid"))
					{
						System.out.print("Enter refundable deposit: ");
						damt = Integer.parseInt(sc.nextLine());
					}
					System.out.print("Set top box inventory details: ");
					String file = sc.nextLine();
					
					STB e1=new STB(id,stb_type,feature,height,width,length,price,icharge,ucharge,disc,bill,damt,file);
					System.out.println(dao.insertData(connection,e1));
				break;
				
				case 3:
					System.out.print("Enter your ID: ");
					id = Integer.parseInt(sc.nextLine());
					dao.deleteData(connection, id);
				break;	
				case 4:
					
					System.out.print("\nChoose your Set top box type from below: \nStandard \nHD \nHD+ \nIPTV\n");
					String sttype = sc.nextLine();
					System.out.print("\nChoose features from below: \nLive recording \nScheduled recording \nPause and play\n");
					String ft = sc.nextLine();
					System.out.print("Enter Height: ");
					int h = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Width: ");
					int w = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Length: ");
					int l = Integer.parseInt(sc.nextLine());
					System.out.print("Enter price: ");
					int p = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Installation charge: ");
					int ic = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Upgradation charge: ");
					int uc = Integer.parseInt(sc.nextLine());
					System.out.print("\nEnter Discount (in %): ");
					int dis = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Billing type: \n1.Prepaid \n2.Postpaid");
					String b = sc.nextLine();
					int da =0;
					if(b.equalsIgnoreCase("postpaid"))
					{
						System.out.print("Enter refundable deposit: ");
						da = Integer.parseInt(sc.nextLine());
					}
					System.out.print("Set top box inventory details: ");
					String f = sc.nextLine();
					System.out.print("Enter your ID: ");
					int eid = Integer.parseInt(sc.nextLine());

					dao.updateData(connection,sttype,ft,h,w,l,p,ic,uc,dis,b,da,f,eid);
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

	
	


