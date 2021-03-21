package Member03;

import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	static DBConnection conn = null;
	@SuppressWarnings("rawtypes")
	Statement stmt = null;
	static String url = "jdbc:mysql://98.142.97.194:3306/sipnenam_itpm_remote_db_by_harsha";
	static String userName = "sipnenam_itpm_remote_db_by_harsha";
	static String password = "ah21%hsaklhagA";
	

	 public static DBConnection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (DBConnection) DriverManager.getConnection(url,userName, password);
			System.out.println("Database connection is success!!!");
		}
			catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
	
	return conn;
	}

}