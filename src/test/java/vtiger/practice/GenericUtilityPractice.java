package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import vtiger.GenericUtilitys.ExcelUtility;
import vtiger.GenericUtilitys.Java_Utility;
import vtiger.GenericUtilitys.PropertyFileUtility;
import vtiger.GenericUtilitys.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException, InterruptedException {

		PropertyFileUtility propertyObj = new PropertyFileUtility();
		String USERNAME = propertyObj.getPropertiesDetails("username");
		String PASSWORD = propertyObj.getPropertiesDetails("password");
		System.out.println("USERNAME :"+USERNAME+"\n"+"PASSWORD :"+PASSWORD);
		
		ExcelUtility excelObj = new ExcelUtility();
		String  name = excelObj. getExcelData("Organization",7,3);
		System.out.println("Indistry name from xl : "+name);

		Java_Utility jvaUtilObj = new Java_Utility();

		System.out.println("random number :" + jvaUtilObj.getRandomNumber());
		System.out.println("getSystemDate : " + jvaUtilObj.getSystemDate());
		System.out.println("getSystemDateInformateWay : " + jvaUtilObj.getSystemDAteInformate());
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anji\\Desktop\\Selinium\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		WebDriverUtility wUtil = new WebDriverUtility();
		
		driver.get("https://demo.actitime.com/login.do");
		
		
		wUtil.maximizWindowe(driver); // mazimizing the window
		Thread.sleep(3000);
		wUtil.minimizeWindow(driver);//minimizing the window
		Thread.sleep(3000);
		wUtil.waitForPsgeLoad(driver); // implecitly wait
		

	}

}
