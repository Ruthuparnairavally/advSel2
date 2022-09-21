package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtils;

public class CreateNewOrganizationPage extends WebDriverUtils {

	@FindBy(name="accountname")
	private WebElement orgNametb;
	
	@FindBy(name="industry")
	private WebElement industrydd;
	
	@FindBy(name="accounttype")
	private WebElement acctypedd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNametb() {
		return orgNametb;
	}
	
	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getAcctypedd() {
		return acctypedd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createNewOrg(String orgName)
	{
		orgNametb.sendKeys(orgName);
		savebtn.click();
	}
	
	public void createNewOrg(String orgName, String indType)
	{
		orgNametb.sendKeys(orgName);
		handleDropDown(industrydd, indType);
		savebtn.click();
	}
	
	public void createNewOrg(String orgName, String indType, String accType)
	{
		orgNametb.sendKeys(orgName);
		handleDropDown(indType, industrydd);
		handleDropDown(accType, acctypedd);
		savebtn.click();
	}
}
