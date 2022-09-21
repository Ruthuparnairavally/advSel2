package vtiger.Contacts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest1 {

	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		
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
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Step 4: click on organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("QSP");
				
				
		//Step 6: navigate to organization link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 7: click on organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 8: Create organization with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("abcd");
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		String parent = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();
		for(String s : child)
		{
			driver.switchTo().window(s);
		}
		
		driver.findElement(By.id("search_txt")).sendKeys("QSP");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("QSP")).click();
		Thread.sleep(3000);
		
		driver.switchTo().window(parent);
	
		//driver.findElement(By.id("title")).sendKeys("addd")	
		
		//Step 6: 
		WebElement elec = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		elec.click();
		Thread.sleep(3000);
		
	
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele3).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	}
}
