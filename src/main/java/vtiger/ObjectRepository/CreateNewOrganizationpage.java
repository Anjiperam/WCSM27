package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilitys.WebDriverUtility;
//import  vtiger.GenericUtilitys.WebDriverUtility;

public class CreateNewOrganizationpage extends WebDriverUtility {
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	 
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgNameEdt()
	{
		return OrgNameEdt;
		
	}
	public WebElement getIndustryDropDwn()
	{
		return IndustryDropDwn;
		
	}
	public void CreateNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	public void CreateNewOrganization(String ORGNAME,String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn,INDUSTRY);
		SaveBtn.click();
	}
	
}
