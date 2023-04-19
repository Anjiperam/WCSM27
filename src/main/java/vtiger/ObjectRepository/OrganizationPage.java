package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement  getCreateOrgLookUpImg()
	{
		return CreateOrgLookUpImg;
	}
	//
	public void clickOnCreateOrganizationLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
}
