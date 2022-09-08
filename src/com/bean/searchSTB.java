package CustomerPurchase;

import CustomerPurchase.CpDAO;

import CustomerPurchase.STB;
import CustomerPurchase.STBDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class searchSTB{
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		System.out.println("Enter Charing Type \n 1. for Post Paid \n 2. for Pre Paid):");
		int ChargingChoice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the STB Type(\\n1. Standard \\n2. HD \\n3. HD+ \\n4. IPTV)");
		String STBType = sc.nextLine().strip();
		CpDAO cp = new CpDAO();
		cp.DisplayBySTBType(connection , STBType);
		
		System.out.println("Enter 1 to purchase: ");
		int Purchase = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Customer name: )");
		String CName = sc.nextLine().strip();
		
		
		cp.Charging(connection , STBType, CName);
		
		
	}
}