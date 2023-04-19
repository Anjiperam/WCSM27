package vtiger.GenericUtilitys;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

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
 * this class we will display all the web driver actions/methods here
 * 
 * @author Anji
 *
 */
public class WebDriverUtility {

	/**
	 * by using this method we will do window minimize
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * by using this method we will do window maximize
	 * 
	 * @param driver
	 */
	public void maximizWindowe(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * it will wait for 20 seconds for page load
	 * 
	 * @param driver
	 */
	public void waitForPsgeLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/**
	 * this method will wait until a particular web element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will wait untill a particular is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * this method will handle drop down by index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method will handle drop down by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * this method will handle drop down by text
	 * 
	 * @param text
	 * @param element
	 */
	public void handledropdown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByValue(text);

	}

	/**
	 * this method will perforn mouse hover actions on a web element
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this method will perform right click on any where in the page
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}

	/**
	 * this method will perform right click on particular web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method will perform double click on anywhere in the page
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * this method will perform double click on particular web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * this method will perform drag and drop from one element to another
	 * 
	 * @param driver
	 * @param scrElement
	 * @param dstElement
	 */
	public void dragAndDropActions(WebDriver driver, WebElement scrElement, WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(scrElement, dstElement).perform();
	}

	/**
	 * this method will press the entee key
	 * 
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * this method will release the entered key
	 * 
	 * @throws AWTException
	 */
	public void releseEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * this method will handle frames with index number
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this meethod will switch to immediate parent frame
	 * 
	 * @param driver
	 */
	public void handleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * this method will switch to default frame
	 * 
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method will accept alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method will dismiss alert popup
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will capture and return the alert text
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * this method take screenshot and save in screenshort folder
	 * 
	 * @param driver
	 * @param screenshortName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShort(WebDriver driver, String screenshortName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShorts\\" + screenshortName + ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	/**
	 * this method will switch to window based on partial window title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle) {
		// step1:capture all windows ids
		Set<String> windId = driver.getWindowHandles();
		// step2: use for each LOPP and navigate to each window
		for (String win : windId) {
			// step3:capture the title of each row
			String currentTitle = driver.switchTo().window(win).getTitle();
			// step4: compare the current title with partial window title
			if (currentTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", null);
	}

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}
}
