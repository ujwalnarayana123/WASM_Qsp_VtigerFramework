package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to all the abstract methods present in ITestListener interface
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports reports;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+" -> test execution started",true);
		
		test = reports.createTest(methodName);
		test.log(Status.INFO,"test script execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+" -> is passed", true);
		
		test.log(Status.PASS, methodName+" -- PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+"-"+jLib.getSytemDateInFormat();
		
		try {
			
			String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			
			test.addScreenCaptureFromPath(path);
			
			test.log(Status.PASS, methodName+" -- FAIL");
			test.log(Status.FAIL, result.getThrowable());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reporter.log(methodName+" -> is failed", true);
		//Reporter.log(result.getThrowable().toString()+" -> reason for failure", true);
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+" -> is skipped", true);
		//Reporter.log(result.getThrowable().toString()+"-> reason for Skip", true);
		
		test.log(Status.PASS, methodName+" -- SKIP");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("execution started", true);
		
		//Since execution is started here, we have to configure extent Reports here.
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSytemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		//attach report to exetentReports
		reports = new ExtentReports(); // main class
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base Browser", "Firefox");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Reporter Name", "Chaitra");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		Reporter.log("execution complete", true);
		
		//Mandatory because, this says all the test script execution is complete and final report
		//can be generated.
		reports.flush();
		
	}
	
	
	
	

}
