package vtiger.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Creating_Organization {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anji\\Desktop\\Selinium\\chromedriver.exe");
				
		PropertiesFile pobj = new PropertiesFile();
		String URL = pobj.getPropertiesDetails("url");
		String BROWSER = pobj.getPropertiesDetails("browser");
		String USERNAME = pobj.getPropertiesDetails("username");
		String PASSWORD = pobj.getPropertiesDetails("password");
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		WebDriver driver =null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
				driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else {
			System.out.println("check your browser");
		}
		// Launch Browser 
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Random r = new Random();
		int add = r.nextInt(100);
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME, Keys.TAB, PASSWORD, Keys.ENTER);
		//Navigate to Organizations link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("anji"+add);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//velidate for Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("anji"))
		{
			System.out.println(orgHeader+"....pass...");
		}
		else {
			System.out.println("....fail....");
		}
		//logout of app/ sign out
		WebElement ele =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver); 
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("successfully");
	}

}
