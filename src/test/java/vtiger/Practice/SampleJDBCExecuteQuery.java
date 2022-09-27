package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Exception
	{
		Driver driverRef = new Driver();

		// Step 1: Register the driver/database
		DriverManager.registerDriver(driverRef);

		// Step 2: Get the connection with database - provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb", "root", "root");

		// Step 3: issue create statement
		Statement state = con.createStatement();

		// Step 4: execute a query - provide table name
		ResultSet result = state.executeQuery("select * from clientinfo;");
		while (result.next()) 
		{
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
		}

		// Step 5: close the database
		con.close();

	}

}
