package vtigerGenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnersImplimenttion implements ITestListener{


	public void onTestStart(ITestResult result) {
		
		String method = result.getMethod().getMethodName();
		Reporter.log(method+" on test start", true);
		
	}

	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName();
		Reporter.log(method+" on Test Success",true  );
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriverUtils wu = new WebDriverUtils();
		JavaUtils ju = new JavaUtils();
		
		String methodname = result.getMethod().getMethodName();
		String name = methodname+"-"+ju.getDateFormat() ; 
		
	/*	try {
			wu.takeScreenshot(BaseClass.sdriver, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Reporter.log(methodname+" onTestFailure",true);
		Reporter.log(result.getThrowable().toString()+"on Test Failure");
		
	}

	public void onTestSkipped(ITestResult result) {
		String method = result.getMethod().getMethodName();
		Reporter.log(method+" onTestSkipped",true);
		Reporter.log(result.getThrowable().toString()+" on Test Skipped",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("execution started",true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("execution completed",true);
	}	
}
