package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitys.ExcelUtility;
import vtiger.GenericUtilitys.Java_Utility;
import vtiger.GenericUtilitys.PropertyFileUtility;
import vtiger.GenericUtilitys.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationpage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrgTest {
	// Step 1: Create Object of Generic Utilities
	ExcelUtility eUtil = new ExcelUtility();
	Java_Utility jUtil = new Java_Utility();

	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException {
		System.out.println(ORG + ":" + INDUSTRY);
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// read all required fields from properties files
		String BROWSER = pUtil.getPropertiesDetails("browser");
		String URL = pUtil.getPropertiesDetails("url");
		String USERNAME = pUtil.getPropertiesDetails("username");
		String PASSWORD = pUtil.getPropertiesDetails("password");
	/*	System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);*/
		String ORGNAME = ORG + jUtil.getRandomNumber();

		WebDriver driver = null;
		// Launching WEb-Browser -run time polymorphism properties
		if (BROWSER.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox");
		} else {
			System.out.println("entered invalid browser");
		}

// minimize and implicitly wait will be perform
		driver.get(URL);
		wUtil.maximizWindowe(driver);
		wUtil.waitForPsgeLoad(driver);

//login with user name and password
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

// click on organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

// click On Create Organization Look Up Img
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrganizationLookUpImg();

//Create New Organization  page with ORGNAME and INDUSTRY
		CreateNewOrganizationpage cnop = new CreateNewOrganizationpage(driver);
		cnop.CreateNewOrganization(ORGNAME, INDUSTRY);
		System.out.println(ORGNAME+" anji :"+INDUSTRY+"  teja");
//Organization Info Page or validation and verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();

		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --- Organization Created ---");
		} else {
			System.out.println(" ----Organization creation Failed ----");
		}
		hp.logoutOfApp(driver);
		System.out.println("logout successfully");
	}

	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] dataObj = eUtil.readDataFromExcelToDataprovide("dataProviderOrg");
		return dataObj;

	}

}
