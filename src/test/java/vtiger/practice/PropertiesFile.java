package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
		
	public String getPropertiesDetails(String data) throws IOException{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	Properties obj = new Properties();
	obj.load(fis);
	String result = obj.getProperty(data);
	/* String BROWSER = obj.getProperty("browser");
	String URL = obj.getProperty("url");
	String USERNAME = obj.getProperty("username");
	String PASSWORD = obj.getProperty("password");
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);*/
	return result;

	}
}

