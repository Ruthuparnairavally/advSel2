package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	public ContactInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getOrgHeader() {
		return header;
	}
	
	public String getHeaderTxt() {
		return header.getText();
	}
}
