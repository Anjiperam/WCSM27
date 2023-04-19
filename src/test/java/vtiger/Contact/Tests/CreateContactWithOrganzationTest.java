package vtiger.Contact.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitys.BaseClass;
import vtiger.GenericUtilitys.Java_Utility;
import vtiger.GenericUtilitys.PropertyFileUtility;
import vtiger.GenericUtilitys.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationpage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.practice.ExcelFile;
//@Listeners(vtiger.GenericUtilitys.ListenersImpklementation.class)
public class CreateContactWithOrganzationTest extends BaseClass {
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
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Step 6: Click on Create Organization Look up Image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrganizationLookUpImg();

		// Step 7: Create organization with mandatory Fields
		CreateNewOrganizationpage cnop = new CreateNewOrganizationpage(driver);
		cnop.CreateNewOrganization(ORGNAME);

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --- Organization Created ---");
		} else {
			System.out.println(" ----Organization creation Failed ----");
		}

		// Step 9: Navigate Contacts Link
		hp.clickOnContactsLink();

		// Step 10: Click on create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 11: Create contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		wUtil.takeScreenShort(driver, "Screenshot1");

		// Step 12: Validate for Contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader + " --- PASS ---");
		} else {
			System.out.println(" ---- Failed ----");
		}

		// Step 13: Logout
		hp.logoutOfApp(driver);
		System.out.println("Sign out successful");

		// Step 11: close the browser
		//driver.quit();

	}

}
