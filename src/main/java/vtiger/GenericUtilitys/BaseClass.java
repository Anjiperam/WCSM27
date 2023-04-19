package vtiger.GenericUtilitys;

import java.io.IOException;

import org.openqa.selenium.WebDriver; 
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	
	// Step 1: Create Object of Generic Utilities
		public ExcelUtility eUtil = new ExcelUtility();
		public PropertyFileUtility pUtil = new PropertyFileUtility();
		public Java_Utility jUtil = new Java_Utility();
		public WebDriverUtility wUtil = new WebDriverUtility();
		
		public WebDriver driver = null;
		public static WebDriver sDriver;

		@BeforeSuite
		public void bsConfig() {
			System.out.println("----- database connection successful -----");
		}

		@BeforeClass
		public void bcConfig() throws IOException {

			String URL = pUtil.getPropertiesDetails("url");
			String BROWSER = pUtil.getPropertiesDetails("browser");

			// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				System.out.println("--- "+BROWSER+" launched ---");
				
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
				System.out.println("--- "+BROWSER+" launched ---");
				
			} else {
				System.out.println("invalid browser name");
			}
			sDriver=driver;
			wUtil.minimizeWindow(driver);
			wUtil.waitForPsgeLoad(driver);
			driver.get(URL);
			
			
		}
		
		
		@BeforeMethod
		public void bmConfig() throws IOException
		{
			String USERNAME = pUtil.getPropertiesDetails("username");
			String PASSWORD = pUtil.getPropertiesDetails("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			System.out.println("--- Login to APP successful ---");
		}

		@AfterMethod
		public void amConfig()
		{
			HomePage hp = new HomePage(driver);
			hp.logoutOfApp(driver);
			
			System.out.println("--- logout of APP successful ---");
		}
		
		@AfterClass
		public void acConfig() 
		{
	         driver.quit();
	         System.out.println("--- Browser closed ---");
		}

		@AfterSuite
		public void asConfig() {
			System.out.println("----- database closed successfully -----");
		}
		
		
	

}
