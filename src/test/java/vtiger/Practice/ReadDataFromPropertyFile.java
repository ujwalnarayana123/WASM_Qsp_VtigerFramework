package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: load the file location into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//step 2: create Object of properties 
		Properties pObj = new Properties();
		
		//Step 3: load the data into properties
		pObj.load(fis);
		
		//Step 4: use the key and read the value
		String BROWSER = pObj.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = pObj.getProperty("url");
		System.out.println(URL);
	}

}
