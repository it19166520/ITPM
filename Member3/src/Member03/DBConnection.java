package Member03;

import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
import javax.swing.*;
public class DBConnection {
	
	
	private static String url = "jdbc:sqlserver://itpmserver.database.windows.net;databaseName=ITPM(New)";
	private static String username = "ITPM";
	private static String password = "GProject#20";
	static //private static Connection con;
	
	
	
	
	Connection conn=null;
	public static Connection dbConnecter()
	{
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,password);
			return conn;
			
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
			
	}
}