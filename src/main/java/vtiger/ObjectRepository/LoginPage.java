package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Rule no:1create a separate POM class for every web page

	// Rule2:identify all the web elements using annotations
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement UserNameEdt;

	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement SubmitBtn;

	// Rule3:initialize these web elements with a constructor

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Rule4: provide getters to access these elements

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

//business library 
	public void loginToApp(String USERNAME, String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		Password.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
