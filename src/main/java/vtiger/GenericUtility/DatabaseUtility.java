package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all the generic methods related to database
 * @author Chaitra M
 *
 */
public class DatabaseUtility {
	
	Driver driverRef;
	Connection con = null;
	
	/**
	 * This method will establish the connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(IConstantsUtility.DBUrl, IConstantsUtility.DBUsername, IConstantsUtility.DBPaswword);
		
	}
	
	/**
	 * this method will close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and verify the exp data in database
	 * and return the data only if exp data and act data are matching
	 * else it will return empty string
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryVerifyDataAndReturn(String query, int columnIndex, String expData) throws SQLException
	{
		//execute a query
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			
			//verify the exp data with act data from database
			if(actData.equals(expData))
			{
				flag = true; // flag rising
				break;
			}
		}
		//return if exp data and act data is matching
		if(flag)
		{
			System.out.println("data verfied");
			return expData;
		}
		else
		{
			System.out.println("data not verfied");
			return "";
		}
		
		
		
		
		
		
	}
	

}
