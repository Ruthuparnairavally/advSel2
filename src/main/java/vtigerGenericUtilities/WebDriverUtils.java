package vtigerGenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods for webdriver actions
 * @author RUTHUPARNA
 *
 */
public class WebDriverUtils {

	/**
	 * This method is used to maximise the window
	 * @param driver
	 */
	
	public void maximise(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitFormDomLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitForElementToVisible(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToClickable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitAndClickOnElement(WebElement ele) throws InterruptedException
	{
		int count=0;
		while(count<10)
		{
			try
			{
				ele.click();
				break;
			}
			catch (Exception e) {
				// TODO: handle exception
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * this method will handle dropdown using select class based on index
	 * @param ele
	 * @param index
	 */
	public void handleDropDown(WebElement ele, int index)
	{
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will handle dropdown using select class based on visible text
	 * @param ele
	 * @param text
	 */
	public void handleDropDown(WebElement ele, String text)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this method will handle dropdown using select class based on value
	 * @param value
	 * @param ele
	 */
	public void handleDropDown(String value, WebElement ele)
	{
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
	}
	
	/**
	 * This method will perform doubleClick action
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick().perform();
	}
	
	/**
	 * This method will perform doubleClick action on element
	 * @param driver
	 * @param ele
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick(ele).perform();
	}
	
	/**
	 * This method will perform rightclick action
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver, WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.contextClick(ele).perform();
	}
	
	/**
	 *  This method will perform rightclick action on page
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions ac = new Actions(driver);
		ac.contextClick().perform();
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDrop(WebDriver driver, WebElement ele1, WebElement ele2)
	{
		Actions ac = new Actions(driver);
		ac.dragAndDrop(ele1, ele2).perform();
	}
	
	/**
	 * This method will perform key press and key relese action
	 * @throws AWTException
	 */
	public void clickEnter() throws Exception
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 *  this method will get the alert text
	 * @param driver
	 * @return
	 */
	public String getTextOfAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or id
	 * @param driver
	 * @param nameorid
	 */
	public void handleFrame(WebDriver driver, String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	
	/**
	 * This method will handle frame based on frame element
	 * @param driver
	 * @param nameorid
	 */
	public void handleFrame(WebDriver driver, WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method will switch the control back to immideate parent
	 * @param driver
	 */
	public void toParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control back to default frame
	 * @param driver
	 */
	public void toDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch from one window to another
	 * @param driver
	 * @param pageTitle
	 */
	public void switchToWindow(WebDriver driver, String pageTitle)
	{
		//Step 1 : get all the window ids
		Set<String> child = driver.getWindowHandles();
		
		//Step 2 : iterate all the window ids
		Iterator<String> itr = child.iterator();
		
		while (itr.hasNext()) {
			//Step 3 : capture the individual window ids
			String id = itr.next();		
			String title = driver.switchTo().window(id).getTitle();
			
			//compare current window id with passed window id
			if(title.contains(pageTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take screenshot and ssave in screenshot folder
	 * @param driver
	 * @param name
	 * @return
	 * @throws IOException 
	 */
	
	public String takeScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(IConstant.photo+name+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	
	/**
	 * this method will scroll window by 500 units
	 * @param driver
	 */
	public void scrolllWindow(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
	}
	
	public void scrollByAction(WebDriver driver, WebElement ele)
	{
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+", "+y+")");
		//js.executeScript("arguments[0].scrollIntoView();", ele);
	}
}
