package DBConnection;

import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.xdevapi.Statement;


public class SqlServerConnection {
	
	
	static Connection conn = null;
	  @SuppressWarnings("rawtypes")
	  Statement stmt = null;
	  static String url = "jdbc:mysql://98.142.97.194:3306/sipnenam_itpm_remote_db_by_harsha";
	  static String userName = "sipnenam_itpm_remote_db_by_harsha";
	  static String password = "ah21%hsaklhagA";
	
	
	
	
	//Connection conn=null;
	public static Connection dbConnecter()
	{
		
		 try {
		        
		        Class.forName("com.mysql.cj.jdbc.Driver"); 
		          conn = DriverManager.getConnection(url,userName, password);
		          System.out.println("Database connection is success!!!");
		        
		      }
		      catch (Exception e) {
		        System.out.println("Database connection is not success!!!");
		      }
		      
		
		 return conn;
		
	}
	
	
	
	
	
	

}