package vtiger.Contacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
import vtigerGenericUtilities.BaseClass;
import vtigerGenericUtilities.DatabaseUtils;
import vtigerGenericUtilities.ExcelUtils;
import vtigerGenericUtilities.JavaUtils;
import vtigerGenericUtilities.PropertyFileUtil;
import vtigerGenericUtilities.WebDriverUtils;

@Listeners(vtigerGenericUtilities.ListnersImplimenttion.class)
public class CreateCntactWithOrg extends BaseClass { 

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void CreateContactWithOrgTest() throws IOException {

		String ORGNAME = eu.readDataFromExcel("Contact", 4, 3)+ju.getRandomNumber();
		String LASTNAME = eu.readDataFromExcel("Contact", 4, 2);
		
		//Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.getOrgnizationpg();
		Reporter.log("Click on Organizations Link",true); //low level reporting
		
		//click on create organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.CreateOrg();
		Reporter.log("Click on create Organizations look up image",true);
		
		//Create organization with mandatory fields and save
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		Reporter.log("new organization created",true);
		
		//Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderTxt();
		
		System.out.println(orgHeader);  //true
		Assert.assertEquals(orgHeader.contains(ORGNAME), true); 
		
		//Navigate to contacts link
		hp.getContactspg();
		Reporter.log("Click on contacts Link",true);
		Assert.fail();
		
		//Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.CreateCon();
		Reporter.log("Click on create contacts Lookup image",true);
		
		//Create contact with Organization and save
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.CreateNewCon(driver, LASTNAME, ORGNAME);
		Reporter.log("new contact created with organization ",true);
		
		//validate for contacts
	    ContactInfoPage cip = new ContactInfoPage(driver);
	    String contactHeader = cip.getHeaderTxt();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		                        //true
		
	}
	
	/*
	@Test(groups = "RegressionSuite")
	public void demoRegressionTest()
	{
		System.out.println("this is regression");
		
		HomePage hp = new HomePage(driver);
		hp.getOrgnizationpg();;
		Reporter.log("Click on Organizations Link",true);
		Assert.fail();
		
		
	}
	*/
}
