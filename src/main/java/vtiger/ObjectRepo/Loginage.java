package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginage {

	//declaration
	@FindBy(name="user_name")
	private WebElement usernameTb;
	
	@FindBy(name="user_password")
	private WebElement passwordTb;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	//Initiaization
	public Loginage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utiization
	public WebElement getUsernameTb() {
		return usernameTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Business Library
	public void login(String userName, String passWord) {
		usernameTb.sendKeys(userName);
		passwordTb.sendKeys(passWord);
		loginbtn.click();
	}
}
