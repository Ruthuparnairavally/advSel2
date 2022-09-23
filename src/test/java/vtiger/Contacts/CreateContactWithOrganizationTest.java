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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.DatabaseUtils;
import vtigerGenericUtilities.ExcelUtils;
import vtigerGenericUtilities.JavaUtils;
import vtigerGenericUtilities.PropertyFileUtil;
import vtigerGenericUtilities.WebDriverUtils;

public class CreateContactWithOrganizationTest extends BaseClass{

	//public static void main(String[] args) throws IOException, InterruptedException {
	
	@Test(groups = "smokesuite")
	public void CreateOrgTest() throws IOException, InterruptedException {
		
		String ORGNAME = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		String LASTNAME =eu.readDataFromExcel("Contact", 4, 2);
		
		//Step 3: navigate to organization link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Step 4: click on organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.quit();
		
		String HEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
	/*	if(HEADER.contains(ORGNAME)) 
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		*/
		
		
		
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
	
}
