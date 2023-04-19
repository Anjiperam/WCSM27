package vtiger.GenericUtilitys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class is contain generic methods related to properties file
 * 
 * @author Anji
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read date from properties file and giving response as key
	 * value formate
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String getPropertiesDetails(String data) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties obj = new Properties();
		obj.load(fis);
		String result = obj.getProperty(data);
		return result;
	}
}
