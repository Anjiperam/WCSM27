package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilitys.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	@FindBy(linkText = "Organizations")
	private WebElement Organizationslnk;

	@FindBy(linkText = "Contacts")
	private WebElement Contactslnk;

	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslnk;

	@FindBy(linkText = "Products")
	private WebElement Productslnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutlnk;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOrganizationlnk() {
		return Organizationslnk;
	}
	//Utilization
	public WebElement getContactslnk() {
		return Contactslnk;
	}
	//Utilization
	public WebElement getOpportunitieslnk() {
		return Opportunitieslnk;
	}
	//Utilization
	public WebElement getProductslnk() {
		return Productslnk;
	}
	//Utilization
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	//Utilization
	public WebElement getSignOutlnk() {
		return SignOutlnk;
	}
	/**
	 * this method will click on Organizationslnk
	 */
	public void clickOnOrganizationsLink()
	{
		Organizationslnk.click();
	}
	/**
	 * this method will click on Contactlnk
	 */
	public void clickOnContactsLink()
	{
		Contactslnk.click();
	}
	public void logoutOfApp(WebDriver driver)
	{
		mouseOverAction(driver,AdministratorImg);
		SignOutlnk.click();
	}
	
}
