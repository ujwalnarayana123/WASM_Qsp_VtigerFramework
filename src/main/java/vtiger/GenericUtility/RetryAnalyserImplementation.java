package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementataion for the IRetryAnalyser interface of TEstNG
 * @author Chaitra M
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		
		return false;
	}

}
