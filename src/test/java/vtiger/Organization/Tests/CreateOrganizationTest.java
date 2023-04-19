
package vtiger.Organization.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitys.ExcelUtility;
import vtiger.GenericUtilitys.Java_Utility;
import vtiger.GenericUtilitys.PropertyFileUtility;
import vtiger.GenericUtilitys.WebDriverUtility;
import vtiger.practice.ExcelFile;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {

		// Step 1: Create Object of Generic Utilities
		ExcelUtility eUtil = new ExcelUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		Java_Utility jUtil = new Java_Utility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step 2: Read all the required Data
		String URL = pUtil.getPropertiesDetails("url");
		String BROWSER = pUtil.getPropertiesDetails("browser");
		String USERNAME = pUtil.getPropertiesDetails("username");
		String PASSWORD = pUtil.getPropertiesDetails("password");

		String ORGNAME = eUtil.getExcelData("dataProviderOrg", 3, 1) + jUtil.getRandomNumber();

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
			System.out.println(OrgHeader + " ---- PASS ----");
		} else {
			System.out.println(" ---- Failed ----");
		}

		// Step 10: Logout of app
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successful");

		// Step 11: close the browser
		driver.quit();

	}

}
