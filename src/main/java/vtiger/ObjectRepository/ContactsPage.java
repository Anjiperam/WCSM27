package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
		/**
		 * BUsiness library
		 */
		public void clickOnCreateContactLookUpImg()
		{
			CreateContactLookUpImg.click();
		}
	
}
