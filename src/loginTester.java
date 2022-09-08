package DTHTester; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Login.login1;
import LoginDB.loginDao;

public class loginTester{

	public static void main(String[] args) throws SQLException {
		
		String jdbcURL = "jdbc:derby:login20;create=true";
		Connection connection = null;
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("The connection is established");
		
		
		loginDao infinity=new loginDao();
		infinity.createTable(connection);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert User Name: ");
		String name = sc.nextLine();
		
		System.out.println("Insert Password: ");
		String pass = sc.nextLine();
		
		
		ResultSet checked = infinity.checkLogin(connection,name,pass);
		
		
		
		if(checked.next()) {
			System.out.println("Successfully logged In");
			
			System.out.println("Enter 'U' to Update the Password:");
			
			String up = sc.nextLine();
			if(up.equals("U")||up.equals("u")) {
				System.out.println("Enter the new pass: ");
				String npass = sc.nextLine(); 
				int updated =   infinity.updatePass(connection,name,npass);
				
				if(updated>0) {
					System.out.println("Successfully password updated.");
				}
				else {
					System.out.println("Sorry! Your password not updated.");
				}
			}
			
			int category = infinity.checkCatg(connection,name,pass);
			String catg = null;
			
			if(category==1) {
				catg = "Admin";
				// Go to Admin page.
			}
			else if(category==1) {
				catg = "Operator";
				// Go to Operator page.
			}
			else {
				catg = "Customer";
				// Go to Customer page.
			}
			System.out.println("Welcome "+catg);
		}
		else{
			System.out.println("Invalied Username or Password");
		}
		connection.close();
	}
}
