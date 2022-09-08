import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Retailer;
import com.dao.RetailerDAO;
import com.bean.ChannelPackage;
import com.dao.ChannelPackageDAO;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:derby:testdb11;create=true";
	Connection connection = null;
	
	public DBConnection() throws SQLException {
		try {
			this.connection = DriverManager.getConnection(JDBC_URL);
			if(this.connection != null) {
				System.out.println("The connection is established.");
			}
		}catch(SQLException e) {
			System.out.println("Connection failed");
		}
		RetailerDAO dao=new RetailerDAO();
		ChannelPackageDAO dao1=new ChannelPackageDAO();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 1 for Retailer and 2 for Channel Packages");
			int inp=Integer.parseInt(sc.nextLine());
			if(inp==1) {
				dao.createTable(connection);
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
						System.out.print("\nEnter your Name: ");
						String name = sc.nextLine();
						System.out.println("\nEnter Contact no. 1: ");
						int ContactNo1=Integer.parseInt(sc.nextLine()); 
						System.out.println("\nEnter Contact no. 2: ");
						int ContactNo2=Integer.parseInt(sc.nextLine());
						System.out.println("\nEnter address line 1: ");
						String add1=sc.nextLine();
						System.out.println("\nEnter Address Line 2: ");
						String add2=sc.nextLine(); 
						System.out.println("\nEnter pincode: ");
						int pinc=Integer.parseInt(sc.nextLine());
						System.out.println("\nEnter city: ");
						String city=sc.nextLine();
						System.out.println("\nEnter state: ");
						String state=sc.nextLine();
						System.out.print("\nEnter your Set top box limit: ");
						int STBL = Integer.parseInt(sc.nextLine());
						System.out.print("\nEnter your Credit Limit: ");
						double CL = Double.parseDouble(sc.nextLine());
						System.out.print("\nEnter Commision percentage: ");
						double CP = Double.parseDouble(sc.nextLine());
						System.out.print("\nEnter your Service Charges: ");
						double SC = Double.parseDouble(sc.nextLine());
						Retailer e1=new Retailer(id, name, ContactNo1, ContactNo2, add1, add2, pinc, city, state, STBL, CL, CP, SC);
						System.out.println(dao.insertData(connection,e1));
						break; 

					case 3:
						System.out.print("Enter your ID: ");
						id = Integer.parseInt(sc.nextLine());
						dao.deleteData(connection, id);
						break;	
					case 4:

						System.out.print("\nEnter your Name: ");
						name = sc.nextLine();
						System.out.println("\nEnter Contact no. 1: ");
						ContactNo1=Integer.parseInt(sc.nextLine()); 
						System.out.println("\nEnter Contact no. 2: ");
						ContactNo2=Integer.parseInt(sc.nextLine());
						System.out.println("\nEnter address line 1: ");
						add1=sc.nextLine();
						System.out.println("\nEnter Address Line 2: ");
						add2=sc.nextLine(); 
						System.out.println("\nEnter pincode: ");
						pinc=Integer.parseInt(sc.nextLine());
						System.out.println("\nEnter city: ");
						city=sc.nextLine();
						System.out.println("\nEnter state: ");
						state=sc.nextLine();
						System.out.print("\nEnter your Set top box limit: ");
						STBL = Integer.parseInt(sc.nextLine());
						System.out.print("\nEnter your Credit Limit: ");
						CL = Double.parseDouble(sc.nextLine());
						System.out.print("\nEnter Commision percentage: ");
						CP = Double.parseDouble(sc.nextLine());
						System.out.print("\nEnter your Service Charges: ");
						SC = Double.parseDouble(sc.nextLine());

						dao.updateData(connection, name, ContactNo1, ContactNo2, add1, add2, pinc, city, state, STBL, CL, CP, SC);
						break;
					}

					System.out.println("Press e to exit!");
					if(sc.nextLine().equals("e"))
					{
						break;
					}
				}
			}
			else if(inp==2) {
				dao1.createTable(connection);
				while(true)
				{
					System.out.println("Menu");
					System.out.println("1. Display\n2. Insert\n3. Delete\n4. Update");

					switch(Integer.parseInt(sc.nextLine()))
					{
					case 1: 
						dao1.displayRecords(connection);
						break;

					case 2: 
						System.out.print("Enter your ID: ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.print("\nEnter your Name: ");
						String name = sc.nextLine();
						System.out.print("\nEnter your category: ");
						String category = sc.nextLine();
						System.out.print("\nEnter your Charging Type: ");
						String ChargingType = sc.nextLine();
						System.out.print("\nEnter your Transmission Type: ");
						String TransmissionType = sc.nextLine();
						System.out.print("\nEnter yes if added by default elso no: ");
						String addbydefault = sc.nextLine();
						ChannelPackage e2=new ChannelPackage(id, name, category, ChargingType, TransmissionType, addbydefault);
						System.out.println(dao1.insertData(connection,e2));
						break; 

					case 3:
						System.out.print("Enter your ID: ");
						id = Integer.parseInt(sc.nextLine());
						dao1.deleteData(connection, id);
						break;	
					case 4:

						System.out.print("\nEnter your Name: ");
						name = sc.nextLine();
						System.out.print("\nEnter your category: ");
						category = sc.nextLine();
						System.out.print("\nEnter your Charging Type: ");
						ChargingType = sc.nextLine();
						System.out.print("\nEnter your Transmission Type: ");
						TransmissionType = sc.nextLine();
						System.out.print("\nEnter yes if added by default elso no: ");
						addbydefault = sc.nextLine();

						dao1.updateData(connection, name, category, ChargingType, TransmissionType, addbydefault);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
