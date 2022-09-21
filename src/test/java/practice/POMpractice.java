package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.ObjectRepo.HomePage;
import vtiger.ObjectRepo.Loginage;

public class POMpractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Loginage lp = new Loginage(driver);
		//lp.getUsernameTb().sendKeys("admin");
		//lp.getPasswordTb().sendKeys("manager");
		//lp.getLoginbtn().click();
		
		lp.login("admin", "manager");
		
		HomePage ho = new HomePage(driver);
		ho.getContactspg();
		ho.signOut(driver);
		driver.close();
		
	}
}
