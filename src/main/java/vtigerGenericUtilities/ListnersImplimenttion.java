package vtigerGenericUtilities;

import java.io.IOException;

import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.digest.Skein.HMacKeyGenerator_256_224;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplimenttion implements ITestListener{

	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String method = result.getMethod().getMethodName();
		//Reporter.log(method+" on test start", true);
		
		test = reports.createTest(method);
		test.log(Status.INFO, method+" test script execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName();
		//Reporter.log(method+" on Test Success",true  );
		
		test.log(Status.PASS, method+" ---PASS");
	}

	public void onTestFailure(ITestResult result) {
		
		//WebDriverUtils wu = new WebDriverUtils();
		Photo po = new Photo();
		JavaUtils ju = new JavaUtils();
		
		String method = result.getMethod().getMethodName();
		String name = method+ju.getDateFormat() ; 
		System.out.println(name);
		//String name = result.getName();
				
		//String n = name.trim();
	
			try {
				String path = po.takeScreenShot(BaseClass.sdriver, name);
				test.addScreenCaptureFromPath(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		//Reporter.log(methodname+" onTestFailure",true);
		//Reporter.log(result.getThrowable().toString()+"on Test Failure",true);
		
		test.log(Status.FAIL, method+" ---FAIL");
		test.log(Status.FAIL, result.getThrowable()+" ---FAIL");
		
	}

	public void onTestSkipped(ITestResult result) {
		String method = result.getMethod().getMethodName();
		//Reporter.log(method+" onTestSkipped",true);
		//Reporter.log(result.getThrowable().toString()+" on Test Skipped",true);
		test.log(Status.SKIP, method+" ---SKIP");
		test.log(Status.SKIP, result.getThrowable()+" ---SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		Reporter.log("execution started",true);
		
		htmlreporter = new ExtentSparkReporter(IConstant.reports);
		htmlreporter.config().setDocumentTitle("Execution Reports");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Vtiger reports");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Base browser", "Chrome");
		reports.setSystemInfo("Base environment", "Testing");
		reports.setSystemInfo("Base url", "http://localhost:8888");
		reports.setSystemInfo("Base platform", "windows");
		reports.setSystemInfo("ReporterName", "Ruthu");
		
		
	}

	public void onFinish(ITestContext context) {
		Reporter.log("execution completed",true);
		reports.flush();
	}	
}
