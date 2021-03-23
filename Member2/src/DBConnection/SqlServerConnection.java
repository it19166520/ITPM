package DBConnection;

import java.sql.*;
import javax.swing.*;
public class SqlServerConnection {
	
	
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
			JOptionPane.showMessageDialog(null,"Connection Successfull !");
			return conn;
			
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
			
	}
}
