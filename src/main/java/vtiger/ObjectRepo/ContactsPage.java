package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@title ='Create Contact...']")
	private WebElement createCon;
	
	//Initiaization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCon() {
		return createCon;
	}
	
	public void CreateCon() {
		createCon.click();
	}
}
