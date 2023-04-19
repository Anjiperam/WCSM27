package generic_utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Creating_Contact {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anji\\Desktop\\Selinium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Teja");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
	}

}
