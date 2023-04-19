package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	@FindBy(xpath = "//span[class='dvHeaderText']")
	private WebElement ContactHeaderText;

	// Constructor
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	/**
	 * business library 
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}
}
