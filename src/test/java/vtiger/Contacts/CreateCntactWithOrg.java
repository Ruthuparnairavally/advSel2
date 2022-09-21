package vtiger.Contacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepo.ContactInfoPage;
import vtiger.ObjectRepo.ContactsPage;
import vtiger.ObjectRepo.CreateNewContactPage;
import vtiger.ObjectRepo.CreateNewOrganizationPage;
import vtiger.ObjectRepo.HomePage;
import vtiger.ObjectRepo.Loginage;
import vtiger.ObjectRepo.OrganizationInfoPage;
import vtiger.ObjectRepo.OrganizationPage;
import vtigerGenericUtilities.DatabaseUtils;
import vtigerGenericUtilities.ExcelUtils;
import vtigerGenericUtilities.JavaUtils;
import vtigerGenericUtilities.PropertyFileUtil;
import vtigerGenericUtilities.WebDriverUtils;

public class CreateCntactWithOrg {
	
	private static final WebDriver WebDriver = null;

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
		
		Loginage lp = new Loginage(driver);
		lp.login(USERNAME, PASSWORD);
		
		HomePage ho = new HomePage(driver);
		ho.getOrgnizationpg();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.CreateOrg();
		
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerorg = oip.getHeaderTxt();
		
		if(headerorg.contains(ORGNAME))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		ho.getContactspg();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.CreateCon();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewCon(driver, LASTNAME, ORGNAME);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headercon = cip.getHeaderTxt();
		
		if(headercon.contains(LASTNAME))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		Thread.sleep(3000);
		ho.signOut(driver);
		driver.close();
		
		
	}
	
}
