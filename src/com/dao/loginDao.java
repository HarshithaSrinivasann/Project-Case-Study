package LoginDB;

import java.sql.*;
import java.util.*;

import Login.login1; 

public class loginDao {
	
	

	public void createTable(Connection connection) throws SQLException
	{
		String sql = "create table Login (uname varchar(30),pass varchar(10),catg varchar(20))";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
		
		String sql1 = "insert into Login(uname, pass, catg) values('arup','arup12','admin')";
		Statement stmt1 = connection.createStatement();
		stmt1.execute(sql1);
		
		sql1 = "insert into Login(uname, pass, catg) values('rinku','rinku12','operator')";
		stmt1 = connection.createStatement();
		stmt1.execute(sql1);
		
		sql1 = "insert into Login(uname, pass, catg) values('subudhi','subu12','customer')";
		stmt1 = connection.createStatement();
		stmt1.execute(sql1);
		
	}
	
	public ResultSet checkLogin(Connection connection, String name, String pass) throws SQLException {
		ResultSet check = null;
		String sql = "select * from Login where uname=? and pass=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,pass);
		
		ResultSet resultObj = ps.executeQuery();
		check = resultObj;
		
		return check; 
	}
	
	
	public int updatePass(Connection connection,String name, String pass) throws SQLException
	{
		String sql="update Login set pass=? where uname=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,pass);
		ps.setString(2,name);
		int updated=ps.executeUpdate();
		return updated;	
	}
	
	public int checkCatg(Connection connection, String name, String pass) throws SQLException {
		int c=0;
		String sql = "select * from Login where uname=? and pass=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,pass);

		ResultSet resultObj = ps.executeQuery();
		if(resultObj.getString("catg").equals("admin")) {
			c=1;
		}
		else if(resultObj.getString("catg").equals("operator")) {
			c=2;
		}
		
		else{
			c=3; 
		}
		
		return c;
	}
}