package vtiger.OrgTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganizationTest3 {

	//public static void main(String[] args) throws InterruptedException, IOException {
	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		WebDriver driver;
		
		//generate random number
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String BROWSER = p.getProperty("browser");
		FileInputStream fise = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		
		Sheet s = wb.getSheet("Organization");
		Row row = s.getRow(1);
		Cell cell = row.getCell(2);
		String ORGANIZATION = cell.getStringCellValue();
		
		//Step 1: launch the browser
		//WebDriverManager.chromedriver().setup();
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
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
			driver = new ChromeDriver();
			System.out.println("Chrome launched");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.findElement(By.name("accountname")).sendKeys(ORGANIZATION+RANDOM);
		
		WebElement ele = driver.findElement(By.name("industry"));
		
		Select sc = new Select(ele);
		sc.selectByVisibleText("Electronics");
		
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		
		Select sc1 = new Select(ele1);
		sc1.selectByVisibleText("Investor");
		
		//Step 6: 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele3).perform();
		System.out.println("done");
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		driver.close();
	}
}
