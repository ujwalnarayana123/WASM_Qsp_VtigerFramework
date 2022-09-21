package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNumber();
		System.out.println(random);
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		
		String d = jLib.getSytemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String browser = pLib.readDataFromPFile("browser");
		System.out.println(browser);
		
		ExcelFileUtility eLib = new ExcelFileUtility();
		String orgName = eLib.readDataFromExcel("Organization", 4, 2);
		System.out.println(orgName);
		eLib.writeDataIntoExcel("Organization", 4, 6, "Chaitra");
		System.out.println("data written");
		
		
		
		
	}

}
