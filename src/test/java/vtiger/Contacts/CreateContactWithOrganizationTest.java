package vtiger.Contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilities.DatabaseUtils;
import vtigerGenericUtilities.ExcelUtils;
import vtigerGenericUtilities.JavaUtils;
import vtigerGenericUtilities.PropertyFileUtil;
import vtigerGenericUtilities.WebDriverUtils;

public class CreateContactWithOrganizationTest {

	//public static void main(String[] args) throws IOException, InterruptedException {
	
	@Test
	public void CreateOrgTest() throws IOException, InterruptedException {
		 
		WebDriver driver;
		
		//Step 1: Create objects of all the utilities
		JavaUtils ju = new JavaUtils();
		PropertyFileUtil pu = new PropertyFileUtil();
		ExcelUtils eu = new ExcelUtils();
		DatabaseUtils du = new DatabaseUtils();
		WebDriverUtils wu = new WebDriverUtils();
		
		//Step 2: Read all the necessary data
		String BROWSER = pu.getDataFrmProp("browser");
		String URL = pu.getDataFrmProp("url");
		String USERNAME = pu.getDataFrmProp("username");
		String PASSWORD = pu.getDataFrmProp("password");
		String ORGNAME = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		String LASTNAME =eu.readDataFromExcel("Contact", 4, 2);
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
		
		//Step 2: login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to organization link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Step 4: click on organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.quit();
		
		String HEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(HEADER.contains(ORGNAME)) 
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']")).click();
		
		wu.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		wu.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String CHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(CHEADER.contains(LASTNAME)) 
		{
			System.out.println("contact PASS");
		}
		else
		{
			System.out.println("contact FAIL");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.mouseHover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		System.out.println("Logged Out");
		driver.close();
		
		
	}
	
	@Test
	public void DemoTest()
	{
		System.out.println("Demo test");
	}
}
