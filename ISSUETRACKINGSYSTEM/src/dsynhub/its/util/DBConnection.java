package dsynhub.its.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static String driverName="oracle.jdbc.driver.OracleDriver";

private static String url="jdbc:oracle:thin:@localhost:1521:XE";
private static String userName="system";
private static String password="priya";
public static Connection getConnection()
{
	Connection conn=null;
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn=DriverManager.getConnection(url, userName, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 if(conn!=null)
	    {
	        System.out.println("Database Connected");
	    }
	 else
	    {
	        System.out.println("Database not connected");
	    }
	   return conn;    
	 }

	 public static void main(String[] args)
	 {
	        DBConnection.getConnection();
	 }

}

