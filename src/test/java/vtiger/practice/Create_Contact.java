package vtiger.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Contact {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anji\\Desktop\\Selinium\\chromedriver.exe");
		PropertiesFile pobj = new PropertiesFile();
		ExcelFile excelobj = new ExcelFile();
		//Random r = new Random();
		//int add = r.nextInt(100);
		String value=excelobj.getExcelData("Organization",1,2);
		//value = value+add;
		String URL = pobj.getPropertiesDetails("url");
		String BROWSER = pobj.getPropertiesDetails("browser");
		String USERNAME = pobj.getPropertiesDetails("username");
		String PASSWORD = pobj.getPropertiesDetails("password");
		System.out.println(value);
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("check your browser");
		}
		// Launch Browser
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Random r = new Random();
		int add = r.nextInt(100);
		// Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME, Keys.TAB, PASSWORD, Keys.ENTER);
		//click on contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//create new contact
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//fill mandatary fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
		//save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		

	}

}
