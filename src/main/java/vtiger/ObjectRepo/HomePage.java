package vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGenericUtilities.WebDriverUtils;

public class HomePage extends WebDriverUtils {

	private static final WebDriver WebDriver = null;

	//declaration
		@FindBy(xpath="//a[text()='Organizations']")
		private WebElement Orgnization;
		
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement Contacts;
		
		@FindBy(xpath="//a[text()='Opportunities']")
		private WebElement Opportunities;
		
		@FindBy(xpath="//a[text()='Products']")
		private WebElement Products;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement admin;
		
		@FindBy(linkText ="Sign Out")
		private WebElement SignOut;
		
		//Initiaization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrgnization() {
			return Orgnization;
		}

		public WebElement getContacts() {
			return Contacts;
		}

		public WebElement getOpportunities() {
			return Opportunities;
		}

		public WebElement getProducts() {
			return Products;
		}
		
		public WebElement getAdmin() {
			return admin;
		}

		public WebElement getSignOut() {
			return SignOut;
		}

		public void getOrgnizationpg() {
			 Orgnization.click();		
	    }

		public void getContactspg() {
			Contacts.click();
		}
		
		public void getOpportunitiespg() {
			Opportunities.click();;
		}

		public void getProductspg() {
			Products.click();
		}
		
		public void signOut(WebDriver driver )
		{
			mouseHover(driver, admin);
			SignOut.click();
		}
}
