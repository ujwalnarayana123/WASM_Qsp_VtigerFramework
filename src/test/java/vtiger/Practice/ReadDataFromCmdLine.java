package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	/**
	 * through eclipse run time values->run as -> run configuration ->click on
	 * present class ->Arguments & pass args
	 */
	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}

}
