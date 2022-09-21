package vtiger.Contacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {

	@Test
	public void createOrgTest()  {
		
		//Step 1: launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		//Step 2: login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to organization link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 4: click on organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 5: Create organization with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("QSP");
		
		//Step 6: 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.close();
	}
}
