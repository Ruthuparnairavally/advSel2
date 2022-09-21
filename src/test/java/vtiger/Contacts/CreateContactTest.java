 package vtiger.Contacts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilities.DatabaseUtils;
import vtigerGenericUtilities.ExcelUtils;
import vtigerGenericUtilities.JavaUtils;
import vtigerGenericUtilities.PropertyFileUtil;
import vtigerGenericUtilities.WebDriverUtils;

public class CreateContactTest {

	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		
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
		
		String LASTNAME = eu.readDataFromExcel("Contact", 1, 2);
		String LEADSOURCE = eu.readDataFromExcel("Contact", 1, 3);
		
		//Step 3: launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			System.out.println("Firefox Browser Launched");
		}
		else
		{
			System.out.println("Invalid");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched");
		}
		
		wu.maximise(driver);
		wu.waitFormDomLoad(driver);
		driver.get(URL);
		
		//Step 4: login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: navigate to contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 5:
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 6:
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement ele1 = driver.findElement(By.name("leadsource"));
		wu.handleDropDown(ele1, LEADSOURCE);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.mouseHover(driver, ele);
		
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		System.out.println("Logged Out");
		driver.close();
	}
}
