package vtigerGenericUtilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepo.HomePage;
import vtiger.ObjectRepo.Loginage;

public class BaseClass {

	public WebDriver driver;
	
	//Step 1: Create objects of all the utilities
	public JavaUtils ju = new JavaUtils();
	public PropertyFileUtil pu = new PropertyFileUtil();
	public ExcelUtils eu = new ExcelUtils();
	public DatabaseUtils du = new DatabaseUtils();
	public WebDriverUtils wu = new WebDriverUtils();
	public static Connection con;
	
	@BeforeSuite(groups="smokesuit")
	public void bsConfig() throws SQLException
	{
		con = du.connectoDb();
		Reporter.log("----------database connected--------", true);
	}
	
	@BeforeClass(groups="smokesuit")
	public void bcConfig() throws SQLException, IOException
	{
		String BROWSER = pu.getDataFrmProp("browser");
		String URL = pu.getDataFrmProp("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    System.out.println("Chrome launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("firefox launched");
		}
		else
		{
			System.out.println("Invalid");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome launched");
		}
		
		wu.maximise(driver);
		wu.waitFormDomLoad(driver);
		driver.get(URL);
		Reporter.log("-------"+BROWSER+" browser launched-------", true);
	}
	
	@BeforeMethod(groups="smokesuit")
	public void bmConfig() throws SQLException, IOException
	{
		String USERNAME = pu.getDataFrmProp("username");
		String PASSWORD = pu.getDataFrmProp("password");
		
	
		Loginage lp = new Loginage(driver);
		lp.login(USERNAME, PASSWORD);
		
		Reporter.log("--------Logged into app --------", true);
	}
	
	@AfterMethod(groups="smokesuit")
	public void amConfig() throws SQLException
	{
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		Reporter.log("-------Logged out-------", true);
	}
	
	@AfterClass(groups="smokesuit")
	public void acConfig() throws SQLException
	{

		driver.close();
		Reporter.log("-------browser closed-------", true);
	}
	
	@AfterSuite(groups="smokesuit")
	public void asConfig() throws SQLException
	{
		du.closeDb();
		Reporter.log("----------database closed--------", true);
	}
}
