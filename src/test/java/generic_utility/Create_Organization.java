package generic_utility;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Organization {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anji\\Desktop\\Selinium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Random r = new Random();
		int add = r.nextInt(100);
		driver.get("http://localhost:8888");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin", Keys.TAB, "admin", Keys.ENTER);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("unilog1"+add);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Save'])[32]")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("uni"))
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
		

	}

}
