package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath="//img[@title ='Create Organization...']")
	private WebElement createOrg;
	
	//Initiaization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	public void CreateOrg() {
		createOrg.click();
	}
}
