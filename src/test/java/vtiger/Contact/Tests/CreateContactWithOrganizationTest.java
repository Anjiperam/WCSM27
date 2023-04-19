package vtiger.Contact.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitys.Java_Utility;
import vtiger.GenericUtilitys.PropertyFileUtility;
import vtiger.GenericUtilitys.WebDriverUtility;
import vtiger.practice.ExcelFile;

public class CreateContactWithOrganizationTest {

	public static void main(String[] args) throws IOException {

		// Step 1: Create Object of Utilities
		ExcelFile eUtil = new ExcelFile();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		Java_Utility jUtil = new Java_Utility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step 2: Read all the necessary Data
		String URL = pUtil.getPropertiesDetails("url");
		String BROWSER = pUtil.getPropertiesDetails("browser");
		String USERNAME = pUtil.getPropertiesDetails("username");
		String PASSWORD = pUtil.getPropertiesDetails("password");

		String LASTNAME = eUtil.getExcelData("Contact", 4, 2);
		String ORGNAME = eUtil.getExcelData("Contact", 4, 3)+jUtil.getRandomNumber();

		WebDriver driver = null;

		// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser name");
		}

		wUtil.minimizeWindow(driver);
		wUtil.waitForPsgeLoad(driver);
		driver.get(URL);

		// Step 4: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 5: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization Look up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 7: Create organization with mandatory Fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 8: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 9: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --- Organization Created");
		} else {
			System.out.println(" ----Organization creation Failed ----");
		}

		// Step 10: Navigate Contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 11: Click on create Contact Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 12: Create contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 13: Click on Org look up Image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		// Step 14: switch the control to child window
		wUtil.swithToWindow(driver, "Accounts");

		// Step 15: search for Organization
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();

		// Step 16: choose the Organization
		// driver.findElement(By.linkText(ORGNAME)).click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath

		// Step 17: switch the control back to main window
		wUtil.swithToWindow(driver, "Contacts");

		// Step 18: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 19: Validate for Organization
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader + " --- PASS ---");
		} else {
			System.out.println(" ---- Failed ----"); 
		}

		// Step 20: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, ele);
		/*Actions act = new Actions(driver);
		act.moveToElement(ele).perform();*/
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successful");

		// Step 11: close the browser
		//driver.quit();

	}

}

