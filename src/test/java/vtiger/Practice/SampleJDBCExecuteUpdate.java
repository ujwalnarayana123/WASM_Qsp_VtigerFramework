package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		Connection con = null;
		
		try {
			
		//Step 1: register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb", "root", "root");
		
		//Step 3: issue create statemnet
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		String query = "insert into clientinfo values('satish',15,'pune');";
		int result = state.executeUpdate(query);
		
		//System.out.println(result);
		if(result==1)
		{
			System.out.println("data inserted");
		}
		else
		{
			System.out.println("data not inserted");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			//step 5:close database
			con.close();
			System.out.println("database closed");
		}

	}

}
