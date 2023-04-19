package vtiger.GenericUtilitys;

import java.util.Date;
import java.util.Random;

/**
 * this class give java ralated methods functionalitys
 */
public class Java_Utility {
	/**
	 * this method will return random numbers
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);

	}

	/**
	 * this method will return current system date
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		return d.toString();

	}
	/**
	 * this method will display our own formate adte and time
	 * @return
	 */

	public String getSystemDAteInformate() {
		Date d = new Date();
		String[] result = d.toString().split(" ");
		String date = result[2];
		String month = result[1];
		String year =result[5];
		String time = result[3].replace(":","-");
		String dataValue = date+"-"+month+"-"+year+"-"+time;
		return dataValue;
	}

}
