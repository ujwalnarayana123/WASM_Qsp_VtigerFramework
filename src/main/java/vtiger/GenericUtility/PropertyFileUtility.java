package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all the generic methods related to property file
 * @author Chaitra M
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read the key from property File and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.PropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
