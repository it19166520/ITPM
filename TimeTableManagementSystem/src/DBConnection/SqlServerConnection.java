package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.xdevapi.Statement;


public class SqlServerConnection {
	
	 static Connection conn = null;
	  @SuppressWarnings("rawtypes")
	  Statement stmt = null;
	  static String url = "jdbc:mysql://151.106.114.2:3306/u271442347_itpm_db_H";
	  static String userName = "u271442347_CTgiPK";
	  static String password = "mzgdt9ezV";


	  public static Connection dbConnecter() {
	      
	      try {
	        
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	          conn = DriverManager.getConnection(url,userName, password);
	          //System.out.println("Database connection is success!!!");
	        
	      }
	      catch (Exception e) {
	        System.out.println("Database connection is not success!!!");
	      }
	      
	      
	      
	      return conn;
	  }

}
