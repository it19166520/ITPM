package DBConnection;

import java.sql.*;
import javax.swing.*;


public class DBConnection {
	
	private static String url = "jdbc:mysql://98.142.97.194:3306/sipnenam_itpm_remote_db_by_harsha";
	private static String username = "sipnenam_itpm_remote_db_by_harsha";
	private static String password = "ah21%hsaklhagA";
	static //private static Connection con;
	
	
	
	
	Connection conn=null;
	public static Connection dbConnecter()
	{
		 try {
		        
		        Class.forName("com.mysql.cj.jdbc.Driver"); 
		          conn = DriverManager.getConnection(url,username, password);
		         // System.out.println("Database connection is success!!!");
		        
		      }
		      catch (Exception e) {
		        System.out.println("Database connection is not success!!!");
		      }
		      
		
		 return conn;
			
	}
	
	
	
	
	
}
