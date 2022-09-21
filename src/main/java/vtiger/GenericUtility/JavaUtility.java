package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all the generic methods related to java 
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate a random integer number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;	
	}
	
	/**
	 * This method will return the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will provide the date and time in a specific format
	 * @return
	 */
	public String getSytemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String currentDate = date+" "+month+" "+year+" "+time;
		return currentDate;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
