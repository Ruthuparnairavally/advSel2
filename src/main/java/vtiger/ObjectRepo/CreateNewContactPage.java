package vtiger.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtils;

public class CreateNewContactPage extends WebDriverUtils {

	@FindBy(name="lastname")
	private WebElement lastname;
	
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement createOrg;
	
	@FindBy(name="search_text")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(name="leadsource")
	private WebElement leadsourcedd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNametb() {
		return lastname;
	}
	
	public void conLastNametb(String conName) {
		lastname.sendKeys(conName);
	}
	
	public WebElement getCreatecon()
	{
		return createOrg;
	}
		
	public WebElement getLeadSource()
	{
		return leadsourcedd;
	}
	
	public WebElement save() {
		return savebtn;
	}

	public void CreateNewCon(String conName)
	{
		lastname.sendKeys(conName);
		savebtn.click();
	}
	
	public void CreateNewCon(String conName, String leadSource)
	{
		lastname.sendKeys(conName);
		handleDropDown(leadSource, leadsourcedd);
		savebtn.click();
	}
	
	public void CreateNewCon(WebDriver driver, String conName, String orgName)
	{
		lastname.sendKeys(conName);
		createOrg.click();
		switchToWindow(driver, "Accounts");
		searchTxt.sendKeys(orgName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		savebtn.click();
	}
}
