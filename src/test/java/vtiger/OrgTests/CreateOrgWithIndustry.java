package vtiger.OrgTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CreateOrgWithIndustry extends BaseClass{

	@Test(dataProvider = "readMultiData")
	public void CreateOrgWithIndTest(String ORG, String INDUSTRY) throws IOException  {
		//Step 2: Read all the necessary data
		
		
		//String ORGNAME = eu.readDataFromExcel("Organization", 4, 2)+ju.getRandomNumber();
		//String INDUSTRY =eu.readDataFromExcel("Organization", 4, 3);
		String ORGNAME = ORG+ju.getRandomNumber();	
		//System.out.println(ORGNAME+ " "+INDUSTRY);	
		
		HomePage hp = new HomePage(driver);
		hp.getOrgnizationpg();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.CreateOrg();
		
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createNewOrg(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage opp = new OrganizationInfoPage(driver);
		String orgHeader = opp.getHeaderTxt();
		
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}	
		
	}
	
	@DataProvider
	public Object[][] readMultiData() throws EncryptedDocumentException, IOException
	{
		return eu.readMultiDataFromExcel("MultipleOrg");
	}
}
